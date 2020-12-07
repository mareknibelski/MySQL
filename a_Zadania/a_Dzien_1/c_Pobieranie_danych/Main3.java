package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


import java.sql.*;

public class Main3 {
    //zapisz poniżej zapytania do bazy
    public static String query1 = "SELECT * FROM movies WHERE name LIKE ?";
    public static String query2 = "SELECT * FROM tickets WHERE price > ?";
    public static String query3 = "SELECT * FROM tickets WHERE quantity > ?";
    public static String query4 = "SELECT * FROM movies WHERE rating > ?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat1 = conn.prepareStatement(query1);
            preStat1.setString(1, "M%");
            ResultSet rs1 = preStat1.executeQuery();
            while (rs1.next()) {
                int id = rs1.getInt("id");
                String name = rs1.getString("name");
                String desc = rs1.getString("description");
                double rating = rs1. getDouble("rating");
                System.out.println(id + " " + name + " " + desc + " " + rating);
            }
            System.out.println();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            preStat2.setDouble(1, 50.30);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("id");
                int quantity = rs2.getInt("quantity");
                double price = rs2.getDouble("price");
                System.out.println(id + " " + quantity + " " + price);
            }
            System.out.println();

            PreparedStatement preStat3 = conn.prepareStatement(query3);
            preStat3.setInt(1, 3);
            ResultSet rs3 = preStat3.executeQuery();
            while (rs3.next()) {
                int id = rs3.getInt("id");
                int quantity = rs3.getInt("quantity");
                double price = rs3.getDouble("price");
                System.out.println(id + " " + quantity + " " + price);
            }
            System.out.println();

            PreparedStatement preStat4 = conn.prepareStatement(query4);
            preStat4.setDouble(1, 6.5);
            ResultSet rs4 = preStat4.executeQuery();
            while (rs4.next()) {
                int id = rs4.getInt("id");
                String name = rs4.getString("name");
                String desc = rs4.getString("description");
                double rating = rs4.getDouble("rating");
                System.out.println(id + " " + name + " " + desc + " " + rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
