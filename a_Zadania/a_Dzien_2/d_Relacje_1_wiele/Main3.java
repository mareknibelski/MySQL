package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import java.sql.*;

public class Main3 {
    public static String query1 = "SELECT * FROM Products JOIN Opinions ON Products.id = Opinions.product_id WHERE Opinions.description IS NOT NULL";
    public static String query2 = "SELECT * FROM Products LEFT JOIN Opinions ON Products.id = Opinions.product_id";
    public static String query3 = "SELECT * FROM Products JOIN Opinions ON Products.id = Opinions.product_id WHERE Opinions.product_id = 1";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idp = rs.getInt("Products.id");
                String name = rs.getString("Products.name");
                String desc = rs.getString("Products.description");
                double price = rs.getDouble("Products.price");
                int ido = rs.getInt("Opinions.id");
                int prod_id = rs.getInt("Opinions.product_id");
                String desco = rs.getString("Opinions.description");
                System.out.println(idp + " " + name + " " + desc + " " + price + " " + ido +
                        " " + prod_id + " " + desco);
            }
            System.out.println();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int idp = rs2.getInt("Products.id");
                String name = rs2.getString("Products.name");
                String desc = rs2.getString("Products.description");
                double price = rs2.getDouble("Products.price");
                int ido = rs2.getInt("Opinions.id");
                int prod_id = rs2.getInt("Opinions.product_id");
                String desco = rs2.getString("Opinions.description");
                System.out.println(idp + " " + name + " " + desc + " " + price + " " + ido +
                        " " + prod_id + " " + desco);
            }
            System.out.println();

            PreparedStatement preStat3 = conn.prepareStatement(query3);
            ResultSet rs3 = preStat3.executeQuery();
            while (rs3.next()) {
                int idp = rs3.getInt("Products.id");
                String name = rs3.getString("Products.name");
                String desc = rs3.getString("Products.description");
                double price = rs3.getDouble("Products.price");
                int ido = rs3.getInt("Opinions.id");
                int prod_id = rs3.getInt("Opinions.product_id");
                String desco = rs3.getString("Opinions.description");
                System.out.println(idp + " " + name + " " + desc + " " + price + " " + ido +
                        " " + prod_id + " " + desco);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
