package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


import java.sql.*;
import java.util.Scanner;

public class Main1 {

    public static String query = "SELECT id, name FROM movies";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + " " + name);
            }

            System.out.println("Proszę podaj ID filmu, który chcesz usunąć");
            Scanner scann = new Scanner(System.in);
            while (!scann.hasNextInt()) {
                System.out.println("To nie jest liczba");
                scann.next();
            }
            int id = scann.nextInt();

            PreparedStatement preStat2 = conn.prepareStatement("DELETE FROM movies WHERE id = ?");
            preStat2.setInt(1, id);
            preStat2.executeUpdate();
            ResultSet rs2 = preStat.executeQuery();
            while (rs2.next()) {
                int ids = rs2.getInt("id");
                String name = rs2.getString("name");
                System.out.println(ids + " " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
