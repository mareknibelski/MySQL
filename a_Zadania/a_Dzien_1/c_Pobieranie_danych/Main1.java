package a_Zadania.a_Dzien_1.c_Pobieranie_danych;

import java.sql.*;

public class Main1 {
    //Zapisz w poniższej zmiennej kod zapytania SQL pobierającego odpowiednie dane
    public static String query = "SELECT * FROM products";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                if (description.length() > 20) {
                    description = description.substring(0, 20) + " ...";
                }
                double price = rs.getDouble("price");
                System.out.println(id + " " + name + " " + description + " " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
