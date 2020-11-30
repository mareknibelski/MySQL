package a_Zadania.a_Dzien_1.b_Dodawanie_danych;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {

    //zapisz poniżej zapytania dodające rekordy do pierwszej tabeli
    public static String table1row1 = "INSERT INTO Cinemas(name, address) VALUES(\"Rialto\", \"Katowice\")";
    public static String table1row2 = "INSERT INTO Cinemas VALUES(NULL, \"Cinema City\", \"Katowice\")";
    public static String table1row3 = "INSERT INTO Cinemas(name, address) VALUES(\"Kosmos\", \"Katowice\")";
    public static String table1row4 = "INSERT INTO Cinemas VALUES(NULL, \"Multikino\", \"Katowice\")";
    public static String table1row5 = "INSERT INTO Cinemas(name, address) VALUES(\"I-Max\", \"Katowice\")";

//zapisz poniżej zapytania dodające rekordy do drugiej tabeli
    public static String table2row1 = "INSERT INTO Movies(name, description, rating) VALUES(\"Las Vegas\", \"Wycieczka do Las Vegas\", 6.3)";
    public static String table2row2 = "INSERT INTO Movies VALUES(NULL, \"Kiler\", \"Przygoda zwykłego człowieka\", 7.7)";
    public static String table2row3 = "INSERT INTO Movies(name, description, rating) VALUES(\"Zielona mila\", \"Opowieść o niewinnym człowieku\", 8.6)";
    public static String table2row4 = "INSERT INTO Movies VALUE(NULL, \"Ania z zielonego wzgóża\", \"Przygody Ani\", 7.2)";
    public static String table2row5 = "INSERT INTO Movies(name, description, rating) VALUES(\"Matrix\", \"Neo odkrywa Matrix\", 7.6)";

//zapisz poniżej zapytania dodające rekordy do trzeciej tabeli
    public static String table3row1 = "INSERT INTO Payments(type, date) VALUES(\"cash\", NOW())";
    public static String table3row2 = "INSERT INTO Payments VALUES(NULL, \"cart\", NOW())";
    public static String table3row3 = "INSERT INTO Payments(type, date) VALUES(\"cash\", NOW())";
    public static String table3row4 = "INSERT INTO Payments VALUES(NULL, \"cart\", NOW())";
    public static String table3row5 = "INSERT INTO Payments(type, date) VALUES(\"cash\", NOW())";

//zapisz poniżej zapytania dodające rekordy do czwartej tabeli
    public static String table4row1 = "INSERT INTO Tickets(quantity, price) VALUES(2, 24.99)";
    public static String table4row2 = "INSERT INTO Tickets VALUES(NULL, 4, 49.98)";
    public static String table4row3 = "INSERT INTO Tickets(quantity, price) VALUES(6, 74.99)";
    public static String table4row4 = "INSERT INTO Tickets VALUES(NULL, 8, 99.98)";
    public static String table4row5 = "INSERT INTO Tickets(quantity, price) VALUES(10, 124.99)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            Statement stat = conn.createStatement();
            stat.executeUpdate(table1row1);
            stat.executeUpdate(table1row2);
            stat.executeUpdate(table1row3);
            stat.executeUpdate(table1row4);
            stat.executeUpdate(table1row5);
            stat.executeUpdate(table2row1);
            stat.executeUpdate(table2row2);
            stat.executeUpdate(table2row3);
            stat.executeUpdate(table2row4);
            stat.executeUpdate(table2row5);
            stat.executeUpdate(table3row1);
            stat.executeUpdate(table3row2);
            stat.executeUpdate(table3row3);
            stat.executeUpdate(table3row4);
            stat.executeUpdate(table3row5);
            stat.executeUpdate(table4row1);
            stat.executeUpdate(table4row2);
            stat.executeUpdate(table4row3);
            stat.executeUpdate(table4row4);
            stat.executeUpdate(table4row5);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
