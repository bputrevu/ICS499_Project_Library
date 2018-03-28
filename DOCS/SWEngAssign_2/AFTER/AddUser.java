/**
 * AddUser.java
 * This class, as used with he Metro Library application, is called by (puAddUser.java) to insert a user-id record
 * into the USER table in the MariaDB database. This class uses the org.mariadb.jdbc.Driver
 * type-4 JDBC driver for Java to connect to MariaDB.
 * <p>
 * This class excepts 6 parameters for user-id setup.
 *
 * @param userId     INT - unique numeric ID for user access.
 * @param cardId     INT - unique numeric ID for user card(s).
 * @param lastName   String - Last name of account holder.
 * @param firstName  String - First name of account holder.
 * @param address     String - Full address of account holder.
 * @param phone       String - Phone number of account holder.
 * @return VOID
 * @see Library System User Guide
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

    private static int nextAvailableCardId = 10000001;
    private int userId = 0
    private int cardId = 0;
    private String lastName = null;
    private String firstName = null;
    private String address = null;
    private String phone = null;


    //Added constructor
    //Assigning a card number. System generated number instead of user specified
    public AddUser(int userId, String lastName, String firstName, String address, String phone) {
        this.userId = userId;
        //Assign the next available card number and increment the nextAvailableCardId
        this.cardId = nextAvailableCardId++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
    }

    //Added getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Display text output of information passed to this class.
    public void printResultSet() {
        System.out.println(" : $SQL");
    }

    // Insert account information into USER table. Try to connect and insert statement.
    // Print stack trace for failed connection.

    //Removed the parameters and taking the values from class variables
    public void insertUser() {

        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            String connectionUrl = "jdbc:mysql://localhost:3306/prod";
            String connectionUser = "user01";
            String connectionPassword = "password";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            stmt = conn.createStatement();

            //use class variables for preparing the SQL statement
            SQL = "insert into USER(userId, cardId, lastName, firstName, address,phone) values ('"
                    + userId
                    + "', '"
                    + cardId
                    + "', '"
                    + lastName
                    + "', '"
                    + firstName
                    + "', '"
                    + address
                    + "','"
                    + phone + "')";

            stmt.executeUpdate(SQL);
            //System.out.println("This is what was received:");
            //System.out.printf("%d, %d, %s, %s, %s, %s", userId, cardId, lastName, firstName, address,phone);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
