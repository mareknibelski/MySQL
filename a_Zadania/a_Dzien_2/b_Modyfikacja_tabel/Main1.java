package a_Zadania.a_Dzien_2.b_Modyfikacja_tabel;


public class Main1 {
    //zapisz poniżej zapytania do bazy
    public String query1 = "ALTER TABLE tickets ADD priceUSD decimal(7,2)";
    public String query2 = "ALTER TABLE movies ADD director char(80)";
    public String query3 = "ALTER TABLE movies MODIFY COLUMN director varchar(50)";
    public String query4 = "ALTER TABLE tickets DROP COLUMN priceUSD";
}
