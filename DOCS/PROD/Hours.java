/*
 * RecomendList: generates a list of book recomendations by connecting to Mariadb.
 * This class is intended to be used with the library program and Java Swing.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Hours {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  Object[][] data = new Object[7][4];
  int row=0;
  int col=0;
  int colmax=4;
        public Hours() {
                try {
                        Class.forName("org.mariadb.jdbc.Driver").newInstance();
                        //String connectionUrl = "jdbc:mysql://localhost:3306/testdb";
                        String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                        String connectionUser = "user01";
                        String connectionPassword = "password";
                        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM HOURS");
                        while (rs.next()) {
                                String LIBRARY_ID = rs.getString("LIBRARY_ID");
        col=0;
        data[row][col] = LIBRARY_ID;
        col++;
                                String DAY = rs.getString("DAY");
        data[row][col] = DAY;
        col++;
                                String OPEN_HOUR = rs.getString("OPEN_HOUR");
        data[row][col] = OPEN_HOUR;
        col++;
                                String CLOSED_HOUR = rs.getString("CLOSED_HOUR");
        data[row][col] = CLOSED_HOUR;
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
