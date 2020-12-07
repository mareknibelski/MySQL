package a_Zadania.a_Dzien_1.c_Pobieranie_danych;


public class Main4 {
    //zapisz poniżej zapytania do bazy
    public String query1 = "SELECT COUNT(quantity) AS all_Tickets FROM tickets";
    public String query2 = "SELECT type, COUNT(*) AS all_By_Type FROM payments GROUP BY type";
    public String query3 = "SELECT AVG(price) FROM tickets";
    public String query4 = "SELECT * FROM payments LIMIT 1, 5";
    public String query5 = "SELECT type, COUNT(*) AS all_By_Type FROM payments GROUP BY type HAVING all_By_Type > 2";
    public String query6 = "SELECT SUM(quantity) AS suma FROM tickets WHERE quantity > 1";
}
