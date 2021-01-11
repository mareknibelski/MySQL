package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import java.sql.*;

public class Main4 {
    public static String query1 = "SELECT * FROM Categories JOIN Categories_sub ON Categories.id = Categories_sub.main_id WHERE Categories.id = ?";
    public static String query2 = "SELECT DISTINCT Categories_sub.main_id, Categories.name FROM Categories JOIN Categories_sub ON Categories.id = Categories_sub.main_id";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query1);
            preStat.setInt(1, 1);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("Categories.id");
                String namec = rs.getString("Categories.name");
                int idcs = rs.getInt("Categories_sub.id");
                int mainid = rs.getInt("Categories_sub.main_id");
                String namecs = rs.getString("Categories_sub.name");
                System.out.println(idc + " " + namec + " " + idcs + " " + mainid + " " + namecs);
            }
            System.out.println();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("Categories_sub.main_id");
                String name = rs2.getString("Categories.name");
                System.out.println(id + " " + name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
