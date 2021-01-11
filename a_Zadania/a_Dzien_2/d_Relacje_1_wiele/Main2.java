package a_Zadania.a_Dzien_2.d_Relacje_1_wiele;


import java.sql.*;

public class Main2 {
//zapisz poniżej zapytania tworzące odpowiednie tabele
    public static String queryAddCategories =  "CREATE TABLE IF NOT EXISTS Categories(" +
        "id int NOT NULL AUTO_INCREMENT," +
        "name varchar(50)," +
        "PRIMARY KEY(id)" +
        ")";

    public static String queryAddCategoriesSub =  "CREATE TABLE IF NOT EXISTS Categories_sub(" +
            "id int NOT NULL AUTO_INCREMENT," +
            "main_id int NOT NULL," +
            "name varchar(50)," +
            "PRIMARY KEY(id)," +
            "FOREIGN KEY(main_id) REFERENCES Categories(id)" +
            "ON DELETE CASCADE" +
            ")";

    public static String queryRelationTable =  "SELECT * FROM Categories JOIN Categories_sub ON Categories.id = Categories_sub.main_id";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/products_ex?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(queryAddCategories);
            preStat.executeUpdate();

            PreparedStatement preStat2 = conn.prepareStatement(queryAddCategoriesSub);
            preStat2.executeUpdate();

            PreparedStatement preStat3 = conn.prepareStatement(queryRelationTable);
            ResultSet rs = preStat3.executeQuery();
            while (rs.next()) {
                int idc = rs.getInt("Categories.id");
                String namec = rs.getString("Categories.name");
                int idcs = rs.getInt("Categories_sub.id");
                int mainid = rs.getInt("Categories_sub.main_id");
                String namesc = rs.getString("Categories_sub.name");
                System.out.println(idc + " " + namec + " " + idcs + " " + mainid + " " + namesc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
