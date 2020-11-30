package a_Zadania.a_Dzien_1.b_Dodawanie_danych;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {

    //zapisz poniżej zapytania dodające rekordy do pierwszej tabeli
    public static String table1row1 = "INSERT INTO Clients(name, surname) VALUES(\"Marek\", \"Nibelski\")";
    public static String table1row2 = "INSERT INTO Clients VALUES(NULL, \"Magda\", \"Żak\")";
    public static String table1row3 = "INSERT INTO Clients(name, surname) VALUES(\"Wiktor\", \"Wikt\")";
    public static String table1row4 = "INSERT INTO Clients VALUES(NULL, \"Dagmara\", \"Jak\")";
    public static String table1row5 = "INSERT INTO Clients(name, surname) VALUES(\"Janusz\", \"Bor\")";

//zapisz poniżej zapytania dodające rekordy do drugiej tabeli
    public static String table2row1 = "INSERT INTO Orders(description) VALUES(\"Opis1\")";
    public static String table2row2 = "INSERT INTO Orders VALUES(NULL, \"Opis2\")";
    public static String table2row3 = "INSERT INTO Orders(description) VALUES(\"Opis3\")";
    public static String table2row4 = "INSERT INTO Orders VALUES(NULL, \"Opis4\")";
    public static String table2row5 = "INSERT INTO Orders(description) VALUES(\"Opis5\")";

//zapisz poniżej zapytania dodające rekordy do trzeciej tabeli
    public static String table3row1 = "INSERT INTO Products(name, description, price) VALUES(\"Protuct1\", \"Opis1\", 8.88)";
    public static String table3row2 = "INSERT INTO Products VALUES(NULL, \"Product2\", \"Opis2\", 17.66)";
    public static String table3row3 = "INSERT INTO Products(name, description, price) VALUES(\"Product3\", \"Opis3\", 35.22)";
    public static String table3row4 = "INSERT INTO Products VALUES(NULL, \"Product4\", \"Opis4\", 70.11)";
    public static String table3row5 = "INSERT INTO Products(name, description, price) VALUES(\"Product5\", \"Opis5\", 140.05)";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
