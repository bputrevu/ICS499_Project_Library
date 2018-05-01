/*
 * AddUser.java: Called bu puAddUser.java - to add a user into the USER & AUTH tables in Mariadb.
 *  insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('1005', '152386116', 'Flintstone ', 'Fred', ' Bedrock','612-234-2222');
 *  Last updated: 4-27-2018
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AddUser {
  private ResultSet rs = null;
  private Connection conn = null;
  private Statement stmt = null;
  private String SQL = null;

   String USER_ID = null;
   String CARD_ID = null;
   String LAST_NAME = null;
   String FIRST_NAME = null;
   String ADDRESS = null;
   String PHONE = null;
   String PASS = null;

  public AddUser() {
     System.out.println("Do nothing until method is called...");
  }

  public void printResultSet()
  {
      System.out.println(" : $SQL");
  }

  public void insertUser (String UID, String CID, String Lname, String Fname, String Adrs,String Phn, String password)
  {
   USER_ID = UID;
   CARD_ID = CID;
   LAST_NAME = Lname;
   FIRST_NAME = Fname;
   ADDRESS = Adrs;
   PHONE = Phn;
   PASS = password;
   try {
      Class.forName("org.mariadb.jdbc.Driver").newInstance();
      String connectionUrl = "jdbc:mysql://localhost:3306/prod";
      String connectionUser = "user01";
      String connectionPassword = "password";
      conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
      stmt = conn.createStatement();
  SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('"+USER_ID+"', '"+CARD_ID+"', '"+LAST_NAME+"', '"+FIRST_NAME+"', '"+ADDRESS+"','"+PHONE+"')";
  //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('"+USER_ID+"', '"+CARD_ID+"', '"+LAST_NAME+"', '"+FIRST_NAME+"', '"+ADDRESS+"','"+PHONE+"')";
      stmt.executeUpdate(SQL);
      System.out.println("This is what was received:");
      System.out.printf("%s, %s, %s, %s, %s, %s", USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE);

      SQL = "insert into AUTH(name, pass) values ('"+USER_ID+"', '"+PASS+"')";
      stmt.executeUpdate(SQL);
      System.out.printf("%s, %s", USER_ID, PASS);

      } catch (Exception e) {
              e.printStackTrace();
      } finally {
              try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
      }
   }
}
