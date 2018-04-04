/*
 * Last update: 4-2-2018
 * titles.java is called by puTitles.java to list all book tables and authors in database.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class titles {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  Object[][] data = new Object[90][2];
  int row=0;
  int col=0;
  int colmax=2;
        public titles() {
        try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                String connectionUser = "user01";
                String connectionPassword = "password";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT TITLE, AUTHOR from BOOK");
                while (rs.next()) {
                        String TITLE = rs.getString("TITLE");
        col=0;
        data[row][col] = TITLE;
        col++;
                                String AUTHOR = rs.getString("AUTHOR");
        data[row][col] = AUTHOR;
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
