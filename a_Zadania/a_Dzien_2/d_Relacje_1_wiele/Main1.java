package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import java.sql.*;

public class Main1 {
    //poniżej zapisz zapytania dodające rekordy do tabeli
    public static String queryProduct1Opinion1 = "INSERT INTO Opinions(product_id, description) VALUES(1, \"Opis1\")";
    public static String queryProduct1Opinion2 = "INSERT INTO Opinions(product_id, description) VALUES(1, \"Opis2\")";
    public static String queryProduct1Opinion3 = "INSERT INTO Opinions(product_id, description) VALUES(1, \"Opis3\")";
    public static String queryProduct1Opinion4 = "INSERT INTO Opinions(product_id, description) VALUES(1, \"Opis4\")";
    public static String queryProduct1Opinion5 = "INSERT INTO Opinions(product_id, description) VALUES(1, \"Opis5\")";

    public static String queryProduct2Opinion1 = "INSERT INTO Opinions(product_id, description) VALUES(2, \"Opis1\")";
    public static String queryProduct2Opinion2 = "INSERT INTO Opinions(product_id, description) VALUES(2, \"Opis2\")";
    public static String queryProduct2Opinion3 = "INSERT INTO Opinions(product_id, description) VALUES(2, \"Opis3\")";
    public static String queryProduct2Opinion4 = "INSERT INTO Opinions(product_id, description) VALUES(2, \"Opis4\")";
    public static String queryProduct2Opinion5 = "INSERT INTO Opinions(product_id, description) VALUES(2, \"Opis5\")";

    public static String queryProduct3Opinion1 = "INSERT INTO Opinions(product_id, description) VALUES(3, \"Opis1\")";
    public static String queryProduct3Opinion2 = "INSERT INTO Opinions(product_id, description) VALUES(3, \"Opis2\")";
    public static String queryProduct31Opinion3 = "INSERT INTO Opinions(product_id, description) VALUES(3, \"Opis3\")";
    public static String queryProduct3Opinion4 = "INSERT INTO Opinions(product_id, description) VALUES(3, \"Opis4\")";
    public static String queryProduct3Opinion5 = "INSERT INTO Opinions(product_id, description) VALUES(3, \"Opis5\")";

    public static String query = "CREATE TABLE IF NOT EXISTS Opinions(" +
            "id int NOT NULL AUTO_INCREMENT," +
            "product_id int NOT NULL," +
            "description varchar(255)," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(product_id) REFERENCES Products(id)" +
            "ON DELETE CASCADE" +
            ")";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("" +
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            Statement stat = conn.createStatement();
            stat.executeUpdate(query);
            stat.executeUpdate(queryProduct1Opinion1);
            stat.executeUpdate(queryProduct1Opinion2);
            stat.executeUpdate(queryProduct1Opinion3);
            stat.executeUpdate(queryProduct1Opinion4);
            stat.executeUpdate(queryProduct1Opinion5);
            stat.executeUpdate(queryProduct2Opinion1);
            stat.executeUpdate(queryProduct2Opinion2);
            stat.executeUpdate(queryProduct2Opinion3);
            stat.executeUpdate(queryProduct2Opinion4);
            stat.executeUpdate(queryProduct2Opinion5);
            stat.executeUpdate(queryProduct3Opinion1);
            stat.executeUpdate(queryProduct3Opinion2);
            stat.executeUpdate(queryProduct31Opinion3);
            stat.executeUpdate(queryProduct3Opinion4);
            stat.executeUpdate(queryProduct3Opinion5);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
