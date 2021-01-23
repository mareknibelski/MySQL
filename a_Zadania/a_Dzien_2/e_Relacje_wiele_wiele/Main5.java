package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import java.sql.*;
import java.util.Scanner;

public class Main5 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public static String query1 = "SELECT * FROM Movies JOIN Cinemas_Movies ON Cinemas_Movies.movie_id = Movies.id JOIN Cinemas ON Cinemas_Movies.cinema_id = Cinemas.id WHERE Cinemas.id = ?";

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj ID kina");
        while (!scann.hasNextInt()) {
            System.out.println("Podaj prawidłowe ID kina");
            scann.next();
        }
        int idm = scann.nextInt();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            preStat.setInt(1, idm);
            System.out.println("Kino o ID " + idm + ":");
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int ids = rs.getInt("Movies.id");
                String name = rs.getString("Movies.name");
                String desc = rs.getString("Movies.description");
                double rating = rs.getDouble("Movies.rating");
                System.out.println("Film o ID " + ids + " " + name + " " + desc + " " + rating);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
