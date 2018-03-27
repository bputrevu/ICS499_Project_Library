/*
 * User: Testng add a user into the USER table in Mariadb.
 *  insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('1005', '152386116', 'Flintstone ', 'Fred', ' Bedrock','612-234-2222');
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

   int USER_ID = 0000;
   int CARD_ID = 0000000;
   String LAST_NAME = null;
   String FIRST_NAME = null;
   String ADDRESS = null;
   String PHONE = null;

  public AddUser() {
     System.out.println("Do nothing until method is called...");
  }

  public void printResultSet()
  {
      System.out.println(" : $SQL");
  }

  public void insertUser (int UID, int CID, String Lname, String Fname, String Adrs,String Phn)
  {
   USER_ID = UID;
   CARD_ID = CID;
   LAST_NAME = Lname;
   FIRST_NAME = Fname;
   ADDRESS = Adrs;
   PHONE = Phn;
   try {
      Class.forName("org.mariadb.jdbc.Driver").newInstance();
      String connectionUrl = "jdbc:mysql://localhost:3306/prod";
      String connectionUser = "user01";
      String connectionPassword = "password";
      conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
      stmt = conn.createStatement();
 //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)" + " values ('1005', '152386116', 'Flintstone ', 'Fred', ' Bedrock','612-234-2222')";
 //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)" + " values ('USER_ID', 'CARD_ID', 'LAST_NAME', 'FIRST_NAME', 'ADDRESS','PHONE')";
  //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)" + " values (USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)";
  //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)" + " values ("'+USER_ID+'", "'+CARD_ID+'", "'+LAST_NAME+'", "'+FIRST_NAME+'", "'+ADDRESS+'","'+PHONE+'")";
  //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ("'+USER_ID+'", "'+CARD_ID+'", "'+LAST_NAME+'", "'+FIRST_NAME+'", "'+ADDRESS+'","'+PHONE+'")";
  //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('+USER_ID+', '+CARD_ID+', '+LAST_NAME+', '+FIRST_NAME+', '+ADDRESS+','+PHONE+')";
  SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('"+USER_ID+"', '"+CARD_ID+"', '"+LAST_NAME+"', '"+FIRST_NAME+"', '"+ADDRESS+"','"+PHONE+"')";
 //SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE)" + " values (U_ID, C_ID, L_NAME, F_NAME, ADRS,PHN)";
      stmt.executeUpdate(SQL);
      System.out.println("This is what was received:");
      System.out.printf("%d, %d, %s, %s, %s, %s", USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE);
      //System.out.printf("%d, %d, %s, %s, %s, %s", U_ID, C_ID, L_NAME, F_NAME, ADRS,PHN);

      } catch (Exception e) {
              e.printStackTrace();
      } finally {
              try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
      }
   }
}
