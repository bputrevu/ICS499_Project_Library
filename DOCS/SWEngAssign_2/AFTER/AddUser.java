 /**
 * AddUser.java
 * This class, as used with he Metro Library application, is called by (puAddUser.java) to insert a user-id record
 * into the USER table in the MariaDB database. This class uses the org.mariadb.jdbc.Driver 
 * type-4 JDBC driver for Java to connect to MariaDB.
 * <p>
 * This class excepts 6 parameters for user-id setup.
 * 
 * @param  USER_ID     INT - unique numeric ID for user access.
 * @param  CARD_ID     INT - unique numeric ID for user card(s).
 * @param  LAST_NAME   String - Last name of account holder.
 * @param  FIRST_NAME  String - First name of account holder.
 * @param  ADDRESS     String - Full address of account holder.
 * @param  PHONE       String - Phone number of account holder.
 * @return             VOID
 * @see                Library System User Guide
 */
 
/*
 * Last Update: 3-22-2018
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

// Display text output of information passed to this class.
public void printResultSet()
{
    System.out.println(" : $SQL");
}

// Insert account information into USER table. Try to connect and insert statement.
// Print stack trace for failed connection.
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
 
        SQL = "insert into USER(USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE) values ('"+USER_ID+"', '"+CARD_ID+"', '"+LAST_NAME+"', '"+FIRST_NAME+"', '"+ADDRESS+"','"+PHONE+"')";
        stmt.executeUpdate(SQL);
        //System.out.println("This is what was received:");
        //System.out.printf("%d, %d, %s, %s, %s, %s", USER_ID, CARD_ID, LAST_NAME, FIRST_NAME, ADDRESS,PHONE);
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
 }
}
