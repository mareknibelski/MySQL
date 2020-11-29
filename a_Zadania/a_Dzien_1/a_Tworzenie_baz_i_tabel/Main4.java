package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {
//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego pierwszą tabelę
	static String queryCreateTable1 = "CREATE TABLE Cinemas(" +
		"id int AUTO_INCREMENT," +
		"name varchar(255)," +
		"address varchar(255)," +
		"PRIMARY KEY(id)" +
		")";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego drugą tabelę
	static String queryCreateTable2 = "CREATE TABLE Movies(" +
		"id int AUTO_INCREMENT," +
		"name varchar(255)," +
		"description varchar(255)," +
		"rating decimal(3,1)," +
		"PRIMARY KEY(id)" +
		")";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego trzecią tabelę
	static String queryCreateTable3 = "CREATE TABLE Tickets(" +
		"id int AUTO_INCREMENT," +
		"quantity int," +
		"price decimal(5,2)," +
		"PRIMARY KEY(id)" +
		")";

//Zapisz w poniższej zmiennej kod zapytania SQL tworzącego czwartą tabelę
	static String queryCreateTable4 = "CREATE TABLE Payments(" +
		"id int AUTO_INCREMENT," +
		"type varchar(255)," +
		"date date," +
		"PRIMARY KEY(id)" +
		")";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
				"root",
				"coderslab"
		)) {
			Statement stat = conn.createStatement();
			stat.executeUpdate(queryCreateTable1);
			stat.executeUpdate(queryCreateTable2);
			stat.executeUpdate(queryCreateTable3);
			stat.executeUpdate(queryCreateTable4);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
