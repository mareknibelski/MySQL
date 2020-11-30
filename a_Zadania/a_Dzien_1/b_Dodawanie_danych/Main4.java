package a_Zadania.a_Dzien_1.b_Dodawanie_danych;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner scann = new Scanner(System.in);
        System.out.println("Wpisz id kina");
        while (!scann.hasNextInt()) {
            System.out.println("To nie jest id");
            scann.next();
        }
        int id = scann.nextInt();
        scann.nextLine();
        System.out.println("Wpisz nazwę kina");
        String name = scann.nextLine();
        System.out.println("Wpisz adres kina");
        String address = scann.nextLine();
        scann.close();

        addCinema(id, name, address);

    }

    static void addCinema(int id, String name, String address) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preSta = conn.prepareStatement("INSERT INTO Cinemas(id, name, address) " +
                    "VALUES(?, ?, ?)");
            preSta.setInt(1, id);
            preSta.setString(2, name);
            preSta.setString(3, address);
            preSta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
