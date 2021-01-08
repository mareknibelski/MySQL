package a_Zadania.a_Dzien_2.c_Relacje_1_1;


import java.sql.*;

public class Main4 {
    public static String query1 = "SELECT * FROM Payments JOIN Tickets ON Payments.id = Tickets.id WHERE type = \"cash\"";
    public static String query2 = "SELECT * FROM Payments JOIN Tickets ON Payments.id = Tickets.id WHERE type = \"transfer\"";
    public static String query3 = "SELECT * FROM Payments JOIN Tickets ON Payments.id = Tickets.id WHERE type = \"card\"";
    public static String query4 = "SELECT * FROM Payments RIGHT JOIN Tickets ON Payments.id = Tickets.id WHERE type IS NULL";

    public static ResultSet rs;

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idp = rs.getInt("Payments.id");
                String type = rs.getString("Payments.type");
                Date date = rs.getDate("Payments.date");
                int idt = rs.getInt("Tickets.id");
                int quantity = rs.getInt("Tickets.quantity");
                double price = rs.getDouble("Tickets.price");
                System.out.println(idp + " " + type + " " + date + " " + idt + " " +
                        quantity + " " + price);
            }
            System.out.println();

            PreparedStatement preStat1 = conn.prepareStatement(query2);
            ResultSet rs1 = preStat1.executeQuery();
            while (rs1.next()) {
                int idp = rs1.getInt("Payments.id");
                String type = rs1.getString("Payments.type");
                Date date = rs1.getDate("Payments.date");
                int idt = rs1.getInt("Tickets.id");
                int quantity = rs1.getInt("Tickets.quantity");
                double price = rs1.getDouble("Tickets.price");
                System.out.println(idp + " " + type + " " + date + " " + idt + " " +
                        quantity + " " + price);
            }
            System.out.println();

            PreparedStatement preStat2 = conn.prepareStatement(query3);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int idp = rs2.getInt("Payments.id");
                String type = rs2.getString("Payments.type");
                Date date = rs2.getDate("Payments.date");
                int idt = rs2.getInt("Tickets.id");
                int quantity = rs2.getInt("Tickets.quantity");
                double price = rs2.getDouble("Tickets.price");
                System.out.println(idp + " " + type + " " + date + " " + idt + " " +
                        quantity + " " + price);
            }
            System.out.println();

            PreparedStatement preStat3 = conn.prepareStatement(query4);
            ResultSet rs3 = preStat3.executeQuery();
            while (rs3.next()) {
                int idp = rs3.getInt("Payments.id");
                String type = rs3.getString("Payments.type");
                Date date = rs3.getDate("Payments.date");
                int idt = rs3.getInt("Tickets.id");
                int quantity = rs3.getInt("Tickets.quantity");
                double price = rs3.getDouble("Tickets.price");
                System.out.println(idp + " " + type + " " + date + " " + idt + " " +
                        quantity + " " + price);
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
