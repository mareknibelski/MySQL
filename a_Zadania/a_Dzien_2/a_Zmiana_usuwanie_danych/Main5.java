package a_Zadania.a_Dzien_2.a_Zmiana_usuwanie_danych;


import java.sql.*;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {

            showCinemas();

            Scanner scan = new Scanner(System.in);
            System.out.println("Wybierz opcje e - edycja, u - usunięcie, x - wyjście z programu");
            String letter = scan.next();

            while (!letter.equals("x") || letter.equals("e") || letter.equals("u")) {

                if (letter.equals("e")) {
                    letter = "";
                    System.out.println("Podaj ID wiersza do edycji");
                    while (!scan.hasNextInt()) {
                        System.out.println("To nie ID wiersza. Proszę podać prawidłowe ID");
                        scan.next();
                    }
                    int ide = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Podaj nową nazwę kina");
                    String namee = scan.nextLine();

                    System.out.println("Podaj nowy adres kina");
                    String addresse = scan.nextLine();

                    PreparedStatement preStat1 = conn.prepareStatement("UPDATE cinemas SET " +
                            "name = ?, address = ? WHERE id = ?");
                    preStat1.setString(1, namee);
                    preStat1.setString(2, addresse);
                    preStat1.setInt(3, ide);
                    preStat1.executeUpdate();
                    showCinemas();
                } else if (letter.equals("u")) {
                    letter = "";
                    System.out.println("Podaj ID wiersza który chcesz usunąć");
                    while (!scan.hasNextInt()) {
                        System.out.println("To nie ID. Proszę podaj prawidło ID");
                        scan.next();
                    }
                    int idu = scan.nextInt();

                    PreparedStatement preStat2 = conn.prepareStatement("DELETE FROM cinemas " +
                            "WHERE id = ?");
                    preStat2.setInt(1, idu);
                    System.out.println("Potwierdź usunięcie wiersza T lub n");
                    if (scan.next().equals("T")) {
                        preStat2.executeUpdate();
                        showCinemas();
                    } else if (scan.nextLine().equals("n")) {
                        System.out.println("Wybierz prawidłowo opcje!!!");
                        letter = scan.next();
                    }
                } else {
                    System.out.println("Wybierz prawidłowo opcje!!!");
                    letter = scan.next();
                }
            }

            System.out.println("Koniec!!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void showCinemas() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement("SELECT * FROM cinemas");
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id + " " + name + " " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
