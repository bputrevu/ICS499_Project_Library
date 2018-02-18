
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySqlJdbcTest {
        public static void main(String[] args) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                Object[][] data = new Object[6][4];
                try {
                        Class.forName("org.mariadb.jdbc.Driver").newInstance();
                        String connectionUrl = "jdbc:mysql://localhost:3306/testdb";
                        String connectionUser = "user01";
                        String connectionPassword = "password";
                        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM BOOKS");
                        while (rs.next()) {
                                String grade = rs.getString("grade");
                        data[0][0] = grade;
                                String title = rs.getString("title");
                        data[0][1] = title;
                                String author = rs.getString("author");
                        data[0][2] = author;
                                String isbn = rs.getString("isbn");
                        data[0][3] = isbn;
                                System.out.println("Grade: " + grade + ", Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
        }
}