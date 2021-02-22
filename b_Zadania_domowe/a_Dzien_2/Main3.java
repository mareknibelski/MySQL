package b_Zadania_domowe.a_Dzien_2;


import java.sql.*;

public class Main3 {

    public static String query = "SELECT movies.name, movies.description, movies.rating, cinemas.name FROM " +
            "movies JOIN screenings ON screenings.movie_id = movies.id JOIN cinemas " +
            "ON screenings.cinema_id = cinemas.id";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                String namem = rs.getString("movies.name");
                String desc = rs.getString("movies.description");
                Double rating = rs.getDouble("movies.rating");
                String namec = rs.getString("cinemas.name");
                System.out.println(namem + " " + desc + " " + rating + " " + namec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
