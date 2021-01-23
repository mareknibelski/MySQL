package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import java.sql.*;
import java.util.Scanner;

public class Main1 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public static String query1 = "CREATE TABLE IF NOT EXISTS Products_Orders(" +
            "id int AUTO_INCREMENT," +
            "prod_id int NOT NULL," +
            "order_id int NOT NULL," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(prod_id) REFERENCES products(id)" +
            "ON DELETE CASCADE," +
            "FOREIGN KEY(order_id) REFERENCES orders(id)" +
            "ON DELETE CASCADE" +
            ")";

    //zapytania łączące produkty z zamówieniami
    public static String query2 = "INSERT INTO Products_Orders(prod_id, order_id) VALUES(1, 1), (1, 2), (1, 3)";
    public static String query3 = "INSERT INTO Products_Orders(prod_id, order_id) VALUES(2, 2), (2, 3), (2, 4)";
    public static String query4 = "INSERT INTO Products_Orders(prod_id, order_id) VALUES(3, 3), (3, 4), (3, 5)";
    public static String query5 = "INSERT INTO Products_Orders(prod_id, order_id) VALUES(4, 4), (4, 5), (5, 1)";

    public static String query6 = "SELECT * FROM Orders JOIN Products_Orders ON Products_Orders.order_id = Orders.id JOIN Products ON Products_Orders.prod_id = Products.id";
    public static String query7 = "SELECT * FROM Products JOIN Products_Orders ON Products_Orders.prod_id = Products.id JOIN Orders ON Products_Orders.order_id = Orders.id WHERE Orders.id = ?";

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj id zamówienia:");
        while (!scann.hasNextInt()) {
            System.out.println("To nie jest ID podaj prawidłowe ID");
            scann.next();
        }
        int idz = scann.nextInt();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            preStat.executeUpdate();

            PreparedStatement preStat1 = conn.prepareStatement(query2);
            preStat1.executeUpdate();
            PreparedStatement preStat2 = conn.prepareStatement(query3);
            preStat2.executeUpdate();
            PreparedStatement preStat3 = conn.prepareStatement(query4);
            preStat3.executeUpdate();
            PreparedStatement preStat4 = conn.prepareStatement(query5);
            preStat4.executeUpdate();

            PreparedStatement preStat5 = conn.prepareStatement(query6);
            ResultSet rs = preStat5.executeQuery();
            while (rs.next()) {
                int ido = rs.getInt("Orders.id");
                String desco = rs.getString("Orders.description");
                int idpo = rs.getInt("Products_Orders.id");
                int idpopid = rs.getInt("Products_Orders.prod_id");
                int idpooid = rs.getInt("Products_Orders.order_id");
                int idp = rs.getInt("Products.id");
                String name = rs.getString("Products.name");
                String descp = rs.getString("Products.description");
                double price = rs.getDouble("Products.price");
                System.out.println(ido + " " + desco + " " + idpo + " " + idpopid + " " +
                        idpooid + " " + idp + " " + name + " " + descp + " " + price);
            }
            System.out.println();

            PreparedStatement preStat6 = conn.prepareStatement(query7);
            preStat6.setInt(1, idz);
            System.out.println("Zamówienie o id " + idz);
            ResultSet rs1 = preStat6.executeQuery();
            while (rs1.next()) {
                int id = rs1.getInt("Products.id");
                String name = rs1.getString("Products.name");
                String desc = rs1.getString("Products.description");
                double price = rs1.getDouble("Products.price");
                System.out.println("Produkt o id " + id + " " + name + " " + desc + " " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
