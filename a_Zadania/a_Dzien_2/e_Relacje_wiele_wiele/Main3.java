package a_Zadania.a_Dzien_2.e_Relacje_wiele_wiele;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main3 {
    //poniżej zapisz zapytanie tworzące tabele i łączące je.
    public static String query1 = "CREATE TABLE IF NOT EXISTS Cinemas_Movies(" +
            "id int AUTO_INCREMENT," +
            "cinema_id int NOT NULL," +
            "movie_id int NOT NULL," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(cinema_id) REFERENCES cinemas(id)" +
            "ON DELETE CASCADE," +
            "FOREIGN KEY(movie_id) REFERENCES movies(id)" +
            "ON DELETE CASCADE" +
            ")";

    public static String query2 = "INSERT INTO Cinemas_Movies(cinema_id, movie_id) VALUES(1, 1), (1, 2), (1, 3)";
    public static String query3 = "INSERT INTO Cinemas_Movies(cinema_id, movie_id) VALUES(2, 2), (2, 3), (2, 4)";
    public static String query4 = "INSERT INTO Cinemas_Movies(cinema_id, movie_id) VALUES(3, 3), (3, 4), (3, 5)";
    public static String query5 = "INSERT INTO Cinemas_Movies(cinema_id, movie_id) VALUES(4, 1), (4, 4), (4, 5)";
    public static String query6 = "INSERT INTO Cinemas_Movies(cinema_id, movie_id) VALUES(5, 2), (5, 3), (5, 5)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat1 = conn.prepareStatement(query1);
            preStat1.executeUpdate();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            preStat2.executeUpdate();

            PreparedStatement preStat3 = conn.prepareStatement(query3);
            preStat3.executeUpdate();

            PreparedStatement preStat4 = conn.prepareStatement(query4);
            preStat4.executeUpdate();

            PreparedStatement preStat5 = conn.prepareStatement(query5);
            preStat5.executeUpdate();

            PreparedStatement preStat6 = conn.prepareStatement(query6);
            preStat6.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
