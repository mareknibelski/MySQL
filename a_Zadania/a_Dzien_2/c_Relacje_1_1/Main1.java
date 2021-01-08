package a_Zadania.a_Dzien_2.c_Relacje_1_1;


public class Main1 {
    //zapisz poniżej zapytania dodający tabelę do bazy pamiętaj o relacji
    public String tableAddQuery = "CREATE TABLE ClientAddress(" +
            "client_id int," +
            "city varchar(50)," +
            "street varchar(50)," +
            "house_nr varchar(10)," +
            "PRIMARY KEY(client_id)," +
            "FOREIGN KEY(client_id) REFERENCES clients(id)" +
            "ON DELETE CASCADE";

    //zapisz poniżej kod dodania do bazy rekordów
    public String tableAddRow1 = "INSERT INTO ClientAddress VALUES(1, \"Katowice\", \"Gall\", 88)";
    public String tableAddRow2 = "INSERT INTO ClientAddress VALUES(2, \"Katowice\", \"Gall\", 88)";
    public String tableAddRow3 = "INSERT INTO ClientAddress VALUES(3, \"Katowice\", \"Osiedle\", 8B)";
    public String tableAddRow4 = "INSERT INTO ClientAddress VALUES(4, \"Chorzów\", \"Armi\", 8A)";
    public String tableAddRow5 = "INSERT INTO ClientAddress VALUES(5, \"Katowice\", \"Osiedle\", 8)";
}
