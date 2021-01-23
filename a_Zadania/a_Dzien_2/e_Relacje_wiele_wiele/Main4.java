package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import java.sql.*;
import java.util.Scanner;

public class Main4 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public static String query1 = "SELECT * FROM Cinemas JOIN Cinemas_Movies ON Cinemas_Movies.cinema_id = Cinemas.id JOIN Movies ON Cinemas_Movies.movie_id = Movies.id WHERE Movies.id = ?";

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Podaj ID filmu");
        while (!scann.hasNextInt()) {
            System.out.println("Podaj prawidłowe ID filmu");
            scann.next();
        }
        int idm = scann.nextInt();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            preStat.setInt(1,  idm);
            System.out.println("Film o id " + idm + ":");
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("Cinemas.id");
                String name = rs.getString("Cinemas.name");
                String address = rs.getString("Cinemas.address");
                System.out.println("* Kino o id " + idc + " " + name + " " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
