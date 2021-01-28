package b_Zadania_domowe.a_Dzien_1;


public class Main1 {
    public String query1 = "SELECT * FROM users WHERE name LIKE \"Julia%\"";

    public String query2 = "SELECT * FROM users ORDER BY email DESC LIMIT 5";

    public String query3 = "SELECT * FROM users WHERE email LIKE \"%@yahoo.com\" AND name LIKE \"L%\"";

    public String query4 = "SELECT * FROM users WHERE sha2(concat(name, '.', salt), 224) = password";

    public String query5 = "SELECT id, title FROM offers WHERE price > 500000";

    public String query6 = "SELECT id, price FROM offers WHERE activation_token = \"\" AND price BETWEEN 2000 AND 400000";

    public String query7 = "SELECT title, price, phone FROM offers WHERE status = 1 AND expire BETWEEN CURRENT_TIMESTAMP() AND date_add(expire, interval 10 day)";

    public String query8 = "SELECT * FROM offers WHERE description LIKE \"%violent%\" AND phone LIKE \"%2%\" AND price > 50000";

    public String query9 = "SELECT * FROM offers WHERE promoted = 0 AND price < 300000 AND title LIKE \"%PLC\"";

    public String query10 = "UPDATE offers SET price = price + 1000 AND id BETWEEN 20 AND 25";

    public String query11 = "DELETE FROM offers WHERE expire <= DATE_ADD(NOW(), INTERVAL - 3 DAY)";

    public String query12 = "DELETE FROM offers WHERE phone LIKE \"+48%\" AND promoted = 1 AND status = 1 AND expire > NOW()";

    public String query13 = "UPDATE offers SET promoted = 1 AND promoted_to = DATE_ADD(NOW(), INTERVAL + 23 DAY) WHERE SUBSTRING(phone, 3, 2) = 48 AND promoted = 0";

    public String query14 = "SELECT * FROM offers WHERE price * 2 < 50000 AND promoted = 1 AND promoted_to > NOW()";

    public String query15 = "UPDATE offers SET description = replace(description, \"%executed%\", \"%founded%\") WHERE phone LIKE \"(%)%\" AND price > 400000";

    public String query16 = "SELECT count(id) AS sum_active FROM offers WHERE expire > NOW() AND status = 1";

    public String query17 = "SELECT owner, COUNT(id) AS sum_user FROM offers WHERE status = 1 AND expire > NOW() GROUP BY owner";

    public String query18 = "SELECT status AS type, COUNT(id) AS counter FROM offers WHERE status = 1 OR status = 2 GROUP BY status";

    public String query19 = "SELECT SUM(price) AS sum_nonactive_nopromoted FROM offers WHERE status = 1 AND expire < NOW() AND promoted = 0";

    public String query20 = "SELECT ROUND(AVG(price), 2) AS avg_price FROM dump.offers WHERE status = 1 AND expire > NOW() AND promoted = 1";
}
