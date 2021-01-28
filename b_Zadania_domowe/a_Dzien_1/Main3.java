package b_Zadania_domowe.a_Dzien_1;


import java.sql.*;

public class Main3 {
    public static String queryAddImages1 = "INSERT INTO images(offer_id, src, dimension) VALUES (1, \"c:\\pulpit\\img1\", \"1600x980\")";
    public static String queryAddImages2 = "INSERT INTO images(offer_id, src, dimension) VALUES (2, \"c:\\pulpit\\img2\", \"1600x980\")";
    public static String queryAddImages3 = "INSERT INTO images(offer_id, src, dimension) VALUES (3, \"c:\\pulpit\\img3\", \"1600x980\")";
    public static String queryAddImages4 = "INSERT INTO images(offer_id, src, dimension) VALUES (4, \"c:\\pulpit\\img4\", \"1600x980\")";
    public static String queryAddImages5 = "INSERT INTO images(offer_id, src, dimension) VALUES (5, \"c:\\pulpit\\img5\", \"1600x980\")";

    public static String queryAddCompany1 = "INSERT INTO users_companies VALUES(1, 1, \"Marek\", 1421786514, \"Ogoniasta\", 24, 123456789, 40-561, 34778.88, 9.9999, NOW())";
    public static String queryAddCompany2 = "INSERT INTO users_companies VALUES(2, 2, \"Magdalena\", 1459714285, \"Ogoniasta\", 24, 123456789, 40-561, 94621.01, 6.4999, NOW())";
    public static String queryAddCompany3 = "INSERT INTO users_companies VALUES(3, 3, \"Klaudia\", 1543156781, \"Mortowa\", 63, 624357641, 40-188, 4234.24, 1.2975, NOW())";
    public static String queryAddCompany4 = "INSERT INTO users_companies VALUES(4, 4, \"Wiktor\", 1123456418, \"Morisowa\", 8, 547694315, 40-189, 99999.99, 1.0001, NOW())";
    public static String queryAddCompany5 = "INSERT INTO users_companies VALUES(5, 5, \"Daria\", 1576383568, \"Skiperowa\", 16, 278641987, 40-246, 2486.54, 1.0002, NOW())";



    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dump?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(queryAddImages1);
            preStat.executeUpdate();
            PreparedStatement preStat1 = conn.prepareStatement(queryAddImages2);
            preStat1.executeUpdate();
            PreparedStatement preStat2 = conn.prepareStatement(queryAddImages3);
            preStat2.executeUpdate();
            PreparedStatement preStat3 = conn.prepareStatement(queryAddImages4);
            preStat3.executeUpdate();
            PreparedStatement preStat4 = conn.prepareStatement(queryAddImages5);
            preStat4.executeUpdate();
            PreparedStatement preStat5 = conn.prepareStatement(queryAddCompany1);
            preStat5.executeUpdate();
            PreparedStatement preStat6 = conn.prepareStatement(queryAddCompany2);
            preStat6.executeUpdate();
            PreparedStatement preStat7 = conn.prepareStatement(queryAddCompany3);
            preStat7.executeUpdate();
            PreparedStatement preStat8 = conn.prepareStatement(queryAddCompany4);
            preStat8.executeUpdate();
            PreparedStatement preStat9 = conn.prepareStatement(queryAddCompany5);
            preStat9.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
