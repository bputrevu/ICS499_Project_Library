/*
 * Last update: 4-21-2018
 * myCheckedOut.java is called by puMyCheckedOut.java to list all books that a specific user checked out (listed in the ManageBook table).
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;


public class myCheckedOut  {
  private ResultSet rs = null;
  private Connection conn = null;
  //private Statement stmt = null;
  PreparedStatement stmt = null;
  Object[][] data = new Object[15][6];
  int row=0;
  int col=0;
  int colmax=6;
  String myGetID;
  String sql;

        //public myCheckedOut() {
        public myCheckedOut(String account) {
        myGetID = account;
        try {
        Class.forName("org.mariadb.jdbc.Driver").newInstance();
        String connectionUrl = "jdbc:mysql://localhost:3306/prod";
        String connectionUser = "user01";
        String connectionPassword = "password";
        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

        String forSql = "%" + myGetID + "%";
        sql = "select * from ManageBook where BORROWED_USER_ID LIKE(?)";
        stmt = conn.prepareStatement(sql); //works
        stmt.setString(1, forSql);
        rs = stmt.executeQuery(); //works



        //stmt = conn.createStatement();
        //rs = stmt.executeQuery("SELECT * from ManageBook");
        while (rs.next()) {
          col=0;
          String ISBN_ID = rs.getString("ISBN_ID");
          data[row][col] = ISBN_ID;
          col++;

          String TITLE = rs.getString("TITLE");
          data[row][col] = TITLE;
          col++;

          String AUTHOR = rs.getString("AUTHOR");
          data[row][col] = AUTHOR;
          col++;

          String BORROWED_USER_ID = rs.getString("BORROWED_USER_ID");
          data[row][col] = BORROWED_USER_ID;
          col++;

          String STATUS = rs.getString("STATUS");
          data[row][col] = STATUS;
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
