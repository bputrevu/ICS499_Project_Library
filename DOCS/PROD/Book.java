/*
 * User: Lists the BOOK table in Mariadb.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Book {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  Object[][] data = new Object[20][6];
  int row=0;
  int col=0;
  int colmax=6;
        public Book() {
        try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                String connectionUser = "user01";
                String connectionPassword = "password";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM BOOK");
                while (rs.next()) {
                String ISBN_ID = rs.getString("ISBN_ID");
        col=0;
        data[row][col] = ISBN_ID;
        col++;
                String TITLE = rs.getString("TITLE");
        data[row][col] = TITLE;
        col++;
                String AUTHOR = rs.getString("AUTHOR");
        data[row][col] = AUTHOR;
        col++;
                String LIBRARY_ID = rs.getString("LIBRARY_ID");
        data[row][col] = LIBRARY_ID;
        col++;
                String BORROWED_USER_ID = rs.getString("BORROWED_USER_ID");
        data[row][col] = BORROWED_USER_ID;
        col++;
                String DUE_DATE = rs.getString("DUE_DATE");
        data[row][col] = DUE_DATE;
        col++;
        row++;
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
      }
      System.out.println();
   }
}

public Object[][] getResultSet()
{
   return(data);
}

}
