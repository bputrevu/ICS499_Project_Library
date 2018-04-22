/*
 * puReturnBook.java - Uses a dialog box to return a checked-out book.
 * 4-22-2018
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


 public class puReturnBook {
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

   public puReturnBook() {



   System.out.println("puReturnBook called...");
   }

        // Method called by puCheckBook.java to return a book
        public void checkBookIn(String searchWord, String searchType, String UID) {
        String searchString = searchWord;
        String searchColumn = searchType;
        String userAcct = UID;
        String sql, forSql, SQL,SQL_A,SQL_B;
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
              System.out.printf("Verified %s is checked out. \n", searchString);
              System.out.printf("OK to return %s. \n", searchString);
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
        if (bookStatus.equals("OUT")) {
           System.out.printf("OK to RETURN the book now. \n");
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
        DUE_DATE = "2018-5-18";
        STATUS = "OUT";

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

      // Here is where we want to delete the entry from the table
      // delete from ManageBook where BORROWED_USER_ID = 'user01' and ISBN_ID = '0375861254';

      SQL = "delete from ManageBook where BORROWED_USER_ID = ? and ISBN_ID = ?";
      //SQL_A = "%" + userAcct + "%";
      //SQL_B = "%" + ISBN_ID + "%";
      SQL_A = userAcct;
      SQL_B = ISBN_ID;

      stmt = conn.prepareStatement(SQL); //
      stmt.setString(1, SQL_A);
      stmt.setString(2, SQL_B);
      System.out.printf("SQL is: %s . \n", SQL);
      System.out.printf("SQL_A is: %s . \n", SQL_A);
      System.out.printf("SQL_B is: %s . \n", SQL_B);
      stmt.executeUpdate();

      System.out.println("Row deleted.... ");

        // Finally return the results of the checkin status in a dialog box.
        JOptionPane.showMessageDialog(null, "Checkin completed successfully. \nTitle : " +  TITLE + "\nAuthor : " + AUTHOR + "\nAcoount : " + userAcct + "\n"  );

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

        // The book is not checked out.Return that information and relaunch the dialog box.
        } else {
          System.out.printf("The book is not checked out. \n");
        JOptionPane.showMessageDialog(null, "The book you selected for check-in is not listed as being checked out. Please check your selection and contact our support line if further assistance is needed.");
        }
 }
}
