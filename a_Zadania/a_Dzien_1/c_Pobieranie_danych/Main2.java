package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


import java.sql.*;

public class Main2 {

    public static String avarage = "SELECT AVG(rating) AS avarage FROM movies";
    public static String query = "SELECT * FROM movies WHERE rating > ?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat1 = conn.prepareStatement(avarage);
            ResultSet rs1 = preStat1.executeQuery();
            while (rs1.next()) {
                double avg = rs1.getDouble("avarage");
                System.out.println("Sredni rating to: " + avg);
                PreparedStatement preStat2 = conn.prepareStatement(query);
                preStat2.setDouble(1, avg);
                ResultSet rs2 = preStat2.executeQuery();
                while (rs2.next()) {
                    int id = rs2.getInt("id");
                    String name = rs2.getString("name");
                    String desc = rs2.getString("description");
                    double rating = rs2.getDouble("rating");
                    System.out.println(id + " " + name + " " + desc + " " + rating);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
