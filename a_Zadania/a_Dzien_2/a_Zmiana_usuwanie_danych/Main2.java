package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


import java.sql.*;
import java.util.Scanner;

public class Main2 {

    public static String query = "SELECT * FROM tickets";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int ids = rs.getInt("id");
                int quantities = rs.getInt("quantity");
                double prices = rs.getDouble("price");
                System.out.println(ids + " " + quantities + " " + prices);
            }

            System.out.println("Podaj ID biletu, który chcesz zmienić");
            Scanner scann = new Scanner(System.in);
            while (!scann.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scann.next();
            }
            int id = scann.nextInt();

            System.out.println("Podaj prawidłową ilość biletów");
            while (!scann.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scann.next();
            }
            int quantity = scann.nextInt();

            PreparedStatement preStat2 = conn.prepareStatement("UPDATE tickets SET " +
                    "quantity = ? WHERE id = ?");
            preStat2.setInt(1, quantity);
            preStat2.setInt(2, id);
            preStat2.executeUpdate();

            ResultSet rs2 = preStat.executeQuery();
            while (rs2.next()) {
                int ids = rs2.getInt("id");
                int quantities = rs2.getInt("quantity");
                double prices = rs2.getDouble("price");
                System.out.println(ids + " " + quantities + " " + prices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
