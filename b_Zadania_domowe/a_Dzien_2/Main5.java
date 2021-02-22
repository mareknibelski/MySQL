package b_Zadania_domowe.a_Dzien_2;


import java.sql.*;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            String name = "";

            Scanner scann = new Scanner(System.in);
            System.out.println("Wybierz film na który chcesz iść do kina:");
            String movie = scann.nextLine();

            String query = "SELECT name, description, rating FROM movies WHERE name = ?";

            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.setString(1, movie);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                String desc = rs.getString("description");
                double rating = rs.getDouble("rating");
                System.out.println(name + " " + desc + " " + rating);
            }

            if (!name.equals(movie)) {
                System.out.println("Nie odnaleziono filmu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
