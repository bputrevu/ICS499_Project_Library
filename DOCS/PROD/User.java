/*
 * User: Lists the USER table in Mariadb.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class User {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  Object[][] data = new Object[30][6];
  int row=0;
  int col=0;
  int colmax=6;
        public User() {
                try {
                        Class.forName("org.mariadb.jdbc.Driver").newInstance();
                        //String connectionUrl = "jdbc:mysql://localhost:3306/testdb";
                        String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                        String connectionUser = "user01";
                        String connectionPassword = "password";
                        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM USER");
                        while (rs.next()) {
                                String USER_ID = rs.getString("USER_ID");
        col=0;
        data[row][col] = USER_ID;
        col++;
                                String CARD_ID = rs.getString("CARD_ID");
        data[row][col] = CARD_ID;
        col++;
                                String LAST_NAME = rs.getString("LAST_NAME");
        data[row][col] = LAST_NAME;
        col++;
                                String FIRST_NAME = rs.getString("FIRST_NAME");
        data[row][col] = FIRST_NAME;
        col++;
                                String ADDRESS = rs.getString("ADDRESS");
        data[row][col] = ADDRESS;
        col++;
                                String PHONE = rs.getString("PHONE");
        data[row][col] = PHONE;
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
