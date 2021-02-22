package b_Zadania_domowe.a_Dzien_2;


import java.sql.*;
import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj nazwę kina:");
        String cinema = scann.nextLine();

        String query = "SELECT id FROM cinemas WHERE name = ?";
        String query2 = "SELECT movies.id FROM movies " +
                    "JOIN screenings ON screenings.movie_id = movies.id " +
                    "JOIN cinemas ON screenings.cinema_id = cinemas.id " +
                    "WHERE cinemas.name = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {

            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.setString(1, cinema);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("id");
                System.out.println("Kino o id " + idc + ":");

                PreparedStatement preStat2 = conn.prepareStatement(query2);
                preStat2.setString(1, cinema);
                ResultSet rs2 = preStat2.executeQuery();
                while (rs2.next()) {
                    int idm = rs2.getInt("movies.id");
                    System.out.println("* Film o id " + idm);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
