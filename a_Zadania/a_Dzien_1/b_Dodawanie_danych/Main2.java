package a_Zadania.a_Dzien_1.b_Dodawanie_danych;

/**
 * Created by dell on 08.02.17.
 */
public class Main2 {

    public String query1 = "INSERT INTO Products SET id=0, name=produkt1, description=name, price=904";
    public String query1fixed = "INSERT INTO Products (id, name, description, price) VALUES (0, \"produkt1\", \"name\", 904)";

    public String query2 = "INSERT INTO Clients VALUES(\"Jan\", \"Kowalski\", 4, \"Mr.\")";
    public String query2fixed = "INSERT INTO Clients VALUES(4, \"Mr.\", \"Jan\", \"Kowalski\")";

    public String query3 = "INSERT INTO Movies(id, rating, name) VALUES(null, \"bardzo dobry\", \"Szybcy i wściekli\")";
    public String query3fixed = "INSERT INTO Movies(id, name, description, rating) VALUES(NULL, \"Szybcy i wściekli\", \"bardzo dobry\", 7.5)";

    public String query4 = "INSERT INTO Payments SET id=90 AND VALUES(\"cash\", NOW())";
    public String query4fixed = "INSERT INTO Payments VALUES(90, \"cash\", NOW())";
}
