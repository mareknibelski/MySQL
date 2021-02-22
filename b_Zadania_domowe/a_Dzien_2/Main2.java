package b_Zadania_domowe.a_Dzien_2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {

    public static String query = "CREATE TABLE Screenings(" +
            "id int AUTO_INCREMENT," +
            "cinema_id int NOT NULL," +
            "movie_id int NOT NULL," +
            "show_time DATETIME," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(cinema_id) REFERENCES Cinemas(id)," +
            "FOREIGN KEY(movie_id) REFERENCES Movies(id)" +
            ")";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            preStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
