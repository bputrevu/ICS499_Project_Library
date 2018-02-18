/*
 * RecomendList: generates a list of book recomendations by connecting to Mariadb.
 * This class is intended to be used with the library program and Java Swing.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RecomendList {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  Object[][] data = new Object[6][4];
  int row=0;
  int col=0;
  int colmax=4;
        public RecomendList() {
                //Connection conn = null;
                //Statement stmt = null;
                //ResultSet rs = null;
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
        col=0;
        data[row][col] = grade;
        col++;
                                String title = rs.getString("title");
        data[row][col] = title;
        col++;
                                String author = rs.getString("author");
        data[row][col] = author;
        col++;
                                String isbn = rs.getString("isbn");
        data[row][col] = isbn;
        col++;
        row++;
                        //      System.out.println("Grade: " + grade + ", Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
}
public void printResultSet()
{
   for(int i = 0; i < row; i++)
   {
      for(int j = 0; j < colmax; j++)
      {
        System.out.printf("%5s ", data[i][j]);
        //System.out.println();
      }
      System.out.println();
   }
}

public Object[][] getResultSet()
{
   return(data);
}



}