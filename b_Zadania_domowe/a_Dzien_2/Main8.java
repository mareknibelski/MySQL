package b_Zadania_domowe.a_Dzien_2;

import java.sql.*;

public class Main8 {

    public static void main(String[] args) {

        String query = "SELECT id, name, max(points) AS points FROM teams";
        String query2 = "SELECT * FROM teams ORDER BY points";
        String query3 = "SELECT team_home, team_away, team_home_goals, team_away_goals FROM games " +
                "JOIN teams ON games.team_home = teams.id " +
                "WHERE teams.name LIKE ?";
        String query4 = "SELECT team_home, team_away, team_home_goals, team_away_goals FROM games " +
                "JOIN teams ON games.team_away = teams.id " +
                "WHERE teams.name LIKE ?";
        String query5 = "SELECT team_home, team_away, team_home_goals, team_away_goals FROM games " +
                "JOIN teams ON games.team_home = teams.id or games.team_away = teams.id " +
                "WHERE teams.name LIKE ?";
        String query6 = "SELECT teams.name, SUM(games.team_home_goals) AS goals FROM games " +
                "JOIN teams ON games.team_home = teams.id " +
                "WHERE teams.name LIKE ?";
        String query7 = "SELECT teams.name, SUM(games.team_away_goals) AS goals FROM games " +
                "JOIN teams ON games.team_away = teams.id " +
                "WHERE teams.name LIKE ?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/football?serverTimezone=UTC",
                "root",
                "coderslab"
        )) {
            PreparedStatement preStat = conn.prepareStatement(query);
            ResultSet rs = preStat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int points = rs.getInt("points");
                System.out.println(id + " " + name + " " + points);
            }
            System.out.println();

            PreparedStatement preStat2 = conn.prepareStatement(query2);
            ResultSet rs2 = preStat2.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("id");
                String name = rs2. getString("name");
                int points = rs2.getInt("points");
                System.out.println(id + " " + name + " " + points);
            }
            System.out.println();

            PreparedStatement preStat3 = conn.prepareStatement(query3);
            preStat3.setString(1, "Naprzód Brwinów");
            ResultSet rs3 = preStat3.executeQuery();
            while (rs3.next()) {
                int teamh = rs3.getInt("games.team_home");
                int teamg = rs3.getInt("games.team_away");
                int hgoals = rs3.getInt("games.team_home_goals");
                int ggoals = rs3.getInt("games.team_away_goals");
                System.out.println(teamh + " " + teamg + " " + hgoals + " " + ggoals);
            }
            System.out.println();

            PreparedStatement preStat4 = conn.prepareStatement(query4);
            preStat4.setString(1, "Naprzód Brwinów");
            ResultSet rs4 = preStat4.executeQuery();
            while (rs4.next()) {
                int teamh = rs4.getInt("games.team_home");
                int teamg = rs4.getInt("games.team_away");
                int hgoals = rs4.getInt("games.team_home_goals");
                int ggoals = rs4.getInt("games.team_away_goals");
                System.out.println(teamh + " " + teamg + " " + hgoals + " " + ggoals);
            }
            System.out.println();

            PreparedStatement preStat5 = conn.prepareStatement(query5);
            preStat5.setString(1, "Naprzód Brwinów");
            ResultSet rs5 = preStat5.executeQuery();
            while (rs5.next()) {
                int teamh = rs5.getInt("games.team_home");
                int teamg = rs5.getInt("games.team_away");
                int hgoals = rs5.getInt("games.team_home_goals");
                int ggoals = rs5.getInt("games.team_away_goals");
                System.out.println(teamh + " " + teamg + " " + hgoals + " " + ggoals);
            }
            System.out.println();

            PreparedStatement preStat6 = conn.prepareStatement(query6);
            preStat6.setString(1, "Naprzód Brwinów");
            ResultSet rs6 = preStat6.executeQuery();
            while (rs6.next()) {
                String team = rs6.getString("teams.name");
                int goals_home = rs6.getInt("goals");
                System.out.println(team + " " + goals_home);
            }
            System.out.println();

            PreparedStatement preStat7 = conn.prepareStatement(query7);
            preStat7.setString(1, "Naprzód Brwinów");
            ResultSet rs7 = preStat7.executeQuery();
            while (rs7.next()) {
                String team = rs7.getString("teams.name");
                int goals_home = rs7.getInt("goals");
                System.out.println(team + " " + goals_home);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
