package b_Zadania_domowe.a_Dzien_2;


import java.sql.*;
import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {

        String query = "SELECT * FROM cinemas";
        String query2 = "SELECT * FROM movies " +
                "JOIN screenings ON screenings.movie_id = movies.id " +
                "JOIN cinemas ON screenings.cinema_id = cinemas.id " +
                "WHERE cinemas.id = ?";
        String query3 = "SELECT * FROM movies " +
                "JOIN screenings ON screenings.movie_id = movies.id " +
                "JOIN cinemas ON screenings.cinema_id = cinemas.id " +
                "WHERE movies.id = ? and cinemas.id = ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(idc + " " + name + " " + address);
            }

            Scanner scann = new Scanner(System.in);
            System.out.println("Podaj ID kina");
            while (!scann.hasNextInt()) {
                System.out.println("ID jest nieprawidłwe");
                scann.next();
            }
            int idc = scann.nextInt();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            preStat2.setInt(1, idc);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int idm = rs2.getInt("movies.id");
                String name = rs2.getString("movies.name");
                String desc = rs2.getString("movies.description");
                System.out.println(idm + " " + name + " " + desc);
            }

            System.out.println("Podaj ID filmu");
            while (!scann.hasNextInt()) {
                System.out.println("ID jest nieprawidłowe");
                scann.next();
            }
            int idm = scann.nextInt();

            PreparedStatement preStat3 = conn.prepareStatement(query3);
            preStat3.setInt(1, idm);
            preStat3.setInt(2, idc);
            ResultSet rs3 = preStat3.executeQuery();
            while (rs3.next()) {
                int idmovie = rs3.getInt("movies.id");
                String namem = rs3.getString("movies.name");
                String descm = rs3.getString("movies.description");
                int idcinema = rs3.getInt("cinemas.id");
                String namec = rs3.getString("cinemas.name");
                String addressc = rs3.getString("cinemas.address");
                System.out.println(idmovie + " " + namem + " " + descm + " " + idcinema + " " + namec + " " + addressc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
