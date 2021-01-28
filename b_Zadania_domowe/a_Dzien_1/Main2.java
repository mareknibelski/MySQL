package b_Zadania_domowe.a_Dzien_1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {
    public static String createTableImagesQuery = "CREATE TABLE IF NOT EXISTS images(" +
            "id int unsigned AUTO_INCREMENT," +
            "offer_id int  unsigned," +
            "src varchar(100)," +
            "dimension varchar(10)," +
            "PRIMARY KEY(id)" +
            ")";

    public static String createTableUsersCompaniesQuery = "CREATE TABLE IF NOT EXISTS users_companies(" +
            "id int unsigned AUTO_INCREMENT," +
            "user_id int unsigned unique," +
            "name varchar(30)," +
            "nip int," +
            "street varchar(50)," +
            "street_nr mediumint," +
            "phone char(9)," +
            "post_code char(6)," +
            "capital decimal(7, 2)," +
            "rate decimal(5, 4)," +
            "create_at datetime," +
            "PRIMARY KEY(id)" +
            ")";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dump?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(createTableImagesQuery);
            preStat.executeUpdate();
            PreparedStatement preStat1 = conn.prepareStatement(createTableUsersCompaniesQuery);
            preStat1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
