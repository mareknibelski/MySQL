package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import java.sql.*;
import java.util.Scanner;

public class Main2 {

    public static String query = "SELECT * FROM Products";
    public static String query1 = "SELECT * FROM Orders JOIN Products_Orders ON Products_Orders.order_id = Orders.id JOIN Products ON Products_Orders.prod_id = Products.id WHERE Products.id = ?";

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj ID produktu");
        while (!scann.hasNextInt()) {
            System.out.println("Podaj prawidłowe ID produktu");
            scann.next();
        }
        int idp = scann.nextInt();

        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                System.out.println(id + " " + name + " " + desc + " " + price);
            }
            System.out.println();

            PreparedStatement preStat1 = conn.prepareStatement(query1);
            preStat1.setInt(1, idp);
            System.out.println("Produkt o id " + idp + ":");
            ResultSet rs1 = preStat1.executeQuery();
            while (rs1.next()) {
                int idz = rs1.getInt("Orders.id");
                String desc = rs1.getString("Orders.description");
                System.out.println("* Zamówienie o id " + idz + " " + desc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
