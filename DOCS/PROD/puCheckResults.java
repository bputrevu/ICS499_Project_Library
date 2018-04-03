/*
 * puCheckResults.java - Uses a dialog box to display check-in/check-out results
 * with the MariaDB ManageBook table.
 * 4-3-2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.sql.PreparedStatement;


 public class puCheckResults {
 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

  private ResultSet rs = null;
  private Connection conn = null;
  PreparedStatement stmt = null;
  Statement stmt1 = null;
  Object[][] data = new Object[10][4];
  int row=0;
  int col=0;
  int colmax=4;
  int count=999999;
  int numberOfRows=0;

   public puCheckResults() {



   System.out.println("puCheckResults called...");
   }

        // Method called by puCheckBook.java to check-out a book
        public void checkBookOut(String searchWord, String searchType, String UID) {
        String searchString = searchWord;
        String searchColumn = searchType;
        String userAcct = UID;
        String sql, forSql, SQL;
        String ISBN_ID  = "null";
        String TITLE  = "null";
        String AUTHOR  = "null";
        String DUE_DATE, STATUS = "null";
        String sqlISBN_ID, sqlTITLE, sqlAUTHOR, sqlBORROWED_USER_ID, sqlSTATUS, sqlDUE_DATE = "null";
        String bookStatus = "";

        JFrame f = new JFrame("Metro Library");
        panel = new JPanel();

        System.out.printf("Title is: %s \n",  searchString);
        System.out.printf("Function requested: %s \n",  searchColumn);
        System.out.printf("User ID is: %s \n",  userAcct);


        //See if book is available - not already checked out.
        // Check database for entry in the ManageBook table

        sql = "select * from ManageBook where TITLE LIKE(?)";
        forSql = "%" + searchString + "%";
        try {
          Class.forName("org.mariadb.jdbc.Driver").newInstance();
          String connectionUrl = "jdbc:mysql://localhost:3306/prod";
          String connectionUser = "user01";
          String connectionPassword = "password";
          conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
          stmt = conn.prepareStatement(sql); //works
          stmt.setString(1, forSql);
          rs = stmt.executeQuery(); //works


          if (rs.next()) {
          // If rs.next() returns a result, it indicates a row has been matched
          // in SQL table ManageBook. This means the book is checked out.
              System.out.printf("%s is checked out. \n", searchString);
              bookStatus = "OUT";
          } else {
              System.out.printf("%s is NOT! checked out. \n", searchString);
              bookStatus = "IN";
          }
        } catch (Exception e) {
        e.printStackTrace();
        }


     // Checking the book status again at this point is just a way to continue the book manage
     // process out side the SQL code that is doing the table lookup.
        if (bookStatus.equals("IN")) {
           System.out.printf("OK to check out the book now. \n");
        sql = "select ISBN_ID, TITLE, AUTHOR from BOOK where TITLE LIKE(?)";
        forSql = "%" + searchString + "%";

        // To checkout get the book information from the book table.
        try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                String connectionUser = "user01";
                String connectionPassword = "password";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.prepareStatement(sql); //works
                stmt.setString(1, forSql);
                rs = stmt.executeQuery(); //works

                while (rs.next()) {
                ISBN_ID = rs.getString("ISBN_ID");
                TITLE = rs.getString("TITLE");
                AUTHOR = rs.getString("AUTHOR");

              System.out.printf("ISBN_ID is: %s . \n", ISBN_ID);
              System.out.printf("TITLE is: %s . \n", TITLE);
              System.out.printf("AUTHOR is: %s . \n", AUTHOR);
              System.out.printf("User ID is: %s \n",  userAcct);
                }
        } catch (Exception e) {
        e.printStackTrace();
        }

        // Next update the ManageBook table with the book checkout information
        DUE_DATE = "2018-4-29";
        STATUS = "OUT";
        //SQL = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values ('"+ISBN_ID+"', '"+TITLE+"', '"+AUTHOR+"', '"+userAcct+"', '"+STATUS+"','"+DUE_DATE+"')";


// Tried this for prepared statement/
        //sql = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values(?,?,?,?,?,?)";
        //sql = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values(?)";
        //sql = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values(?),(?),(?),(?),(?),(?)";

        sql = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values(?,?,?,?,?,?)";
        sqlISBN_ID = "%" + ISBN_ID + "%";
        sqlTITLE = "%" + TITLE + "%";
        sqlAUTHOR = "%" + AUTHOR + "%";
        sqlBORROWED_USER_ID = "%" + userAcct + "%";
        sqlSTATUS = "%" + STATUS + "%";
        sqlDUE_DATE = "%" + DUE_DATE + "%";

try {
      Class.forName("org.mariadb.jdbc.Driver").newInstance();
      String connectionUrl = "jdbc:mysql://localhost:3306/prod";
      String connectionUser = "user01";
      String connectionPassword = "password";
      conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

      System.out.println("Try SQL update:");
      stmt1 = conn.createStatement();
      SQL = "insert into ManageBook(ISBN_ID, TITLE, AUTHOR, BORROWED_USER_ID, STATUS, DUE_DATE) values ('"+ISBN_ID+"', '"+TITLE+"', '"+AUTHOR+"', '"+userAcct+"', '"+STATUS+"','"+DUE_DATE+"')";

      stmt1.executeUpdate(SQL);
      System.out.println("Row inserted.... ");

        // Finally return the results of the checkout status in a dialog box.
        JOptionPane.showMessageDialog(null, "Checkout completed successfully. \nTitle : " +  TITLE + "\nAuthor : " + AUTHOR + "\nAcoount : " + userAcct + "\nDue : " + DUE_DATE );

      } catch (Exception e) {
              e.printStackTrace();
      }
      finally {
              try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (stmt1 != null) stmt1.close(); } catch (SQLException e) { e.printStackTrace(); }
              try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
      }
        // Finally return the results of the checkout status in a dialog box.
        //JOptionPane.showMessageDialog(null, "Checkout completed successfully. \nTitle : " +  TITLE + "\nAuthor : " + AUTHOR + "\nAcoount : " + userAcct + "\nDue : " + DUE_DATE );

        // The book is checked out.Return that information and relaunch the checkout dialog box.
        } else {
          System.out.printf("The book is not available. \n");
        JOptionPane.showMessageDialog(null, "The book you selected is not avaiable for check out. Please make another selection.");
        }
 }
}
