package b_Zadania_domowe.a_Dzien_2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1 {

    public static String queryRelationImages = "ALTER TABLE images ADD FOREIGN KEY(offer_id) " +
            "REFERENCES offers(id) ON DELETE CASCADE";

    public static String queryRelationUsersCompanies = "ALTER TABLE users_companies ADD FOREIGN KEY(user_id)" +
            "REFERENCES users(id) ON DELETE CASCADE";

    public static String query = "ALTER TABLE users_companies DROP COLUMN id";

    public static String query2 = "ALTER TABLE users_companies ADD PRIMARY KEY(user_id)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dump?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(queryRelationImages);
            preStat.executeUpdate();
            PreparedStatement preStat2 = conn.prepareStatement(queryRelationUsersCompanies);
            preStat2.executeUpdate();
            PreparedStatement preStat3 = conn.prepareStatement(query);
            preStat3.executeUpdate();
            PreparedStatement preStat4 = conn.prepareStatement(query2);
            preStat4.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
