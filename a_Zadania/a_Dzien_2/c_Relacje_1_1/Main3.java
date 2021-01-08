package a_Zadania.a_Dzien_2.c_Relacje_1_1;


import java.sql.*;

public class Main3 {
    //zapisz poniżej zapytanie tworzące tabelę - pamiętaj o relacji i dodaniu odpowiedniej kolumny
    public static String queryCreateTable = "CREATE TABLE IF NOT EXISTS Payments(" +
            "id int NOT NULL," +
            "type varchar(50)," +
            "date date," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(id) REFERENCES tickets(id)" +
            "ON DELETE CASCADE" +
            ")";

    public static String query = "INSERT INTO Payments VALUES(1, \"cash\", \"2021-01-01\")";
    public static String query1 = "INSERT INTO Payments VALUES(2, \"transfer\", \"2021-01-02\")";
    public static String query2 = "INSERT INTO Payments VALUES(3, \"card\", \"2021-01-03\")";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            Statement Stat = conn.createStatement();
            Stat.executeUpdate(queryCreateTable);
            Stat.executeUpdate(query);
            Stat.executeUpdate(query1);
            Stat.executeUpdate(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
