package a_Zadania.a_Dzien_1.a_Tworzenie_baz_i_tabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
	//Zapisz w poniższej zmiennej kod zapytania SQL
	public static String query = "CREATE DATABASE products_ex";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/?serverTimezone=UTC",
				"root",
				"coderslab"
		)){
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
