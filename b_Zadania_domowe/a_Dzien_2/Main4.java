package b_Zadania_domowe.a_Dzien_2;


import java.sql.*;

public class Main4 {

    public static String query = "SELECT cinemas.name, movies.name, screenings.show_time FROM cinemas " +
            "JOIN screenings ON screenings.cinema_id = cinemas.id " +
            "LEFT JOIN movies ON screenings.movie_id = movies.id";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                String namec = rs.getString("cinemas.name");
                String namem = rs.getString("movies.name");
                String showTime = rs.getString("screenings.show_time");
                System.out.println(namec + " " + namem + " " + showTime);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
