package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego pierwszą tabelę
	public static String queryCreateTable1 = "CREATE TABLE Products(" +
		"id int AUTO_INCREMENT," +
		"name varchar(255)," +
		"description varchar(255)," +
		"price decimal(6,2)," +
		"PRIMARY KEY(id)" +
		")";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego drugą tabelę
	public static String queryCreateTable2 = "CREATE TABLE Orders(" +
		"id int AUTO_INCREMENT," +
		"description varchar(255)," +
		"PRIMARY KEY(id)" +
		")";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego trzecią tabelę
	public static String queryCreateTable3 = "CREATE TABLE Clients(" +
		"id int AUTO_INCREMENT," +
		"name varchar(255)," +
		"surname varchar(255)," +
		"PRIMARY KEY(id)" +
		")";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
				"root",
				"coderslab"
		)) {
			Statement stat = conn.createStatement();
			stat.executeUpdate(queryCreateTable1);
			stat.executeUpdate(queryCreateTable2);
			stat.executeUpdate(queryCreateTable3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
