/*
 * puSearchResults.java - Testing using a dialog box to displaysearch results from MariaDB BOOK table.
 * 3--25--2018
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


 public class puSearchResults {
 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

  private ResultSet rs = null;
  private Connection conn = null;
  PreparedStatement stmt = null;
  Object[][] data = new Object[10][4];
  int row=0;
  int col=0;
  int colmax=4;

   public puSearchResults() {

   System.out.println("puSearchResults called...");
   }
        public void search(String searchWord, String searchType) {
        String searchString = searchWord;
        String searchColumn = searchType;
        String sql;
        JFrame f = new JFrame("Metro Library");
        panel = new JPanel();

        System.out.printf("Search word or phrase is: %s \n",  searchString);



switch(searchColumn)
{
   case "AUTHOR" :
      sql = "select * from BOOK where AUTHOR LIKE(?)";
      System.out.printf("CASE = AUTHOR : %s \n",  searchColumn);
      System.out.printf("SQL selected is: %s \n",  sql);
      break;

   case "TITLE" :
      sql = "select * from BOOK where TITLE LIKE(?)";
      System.out.printf("CASE = TITLE : %s \n",  searchColumn);
      System.out.printf("SQL selected is: %s \n",  sql);
      break;

   default :
      sql = "select * from BOOK where ISBN LIKE(?)";
}





        try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                String connectionUrl = "jdbc:mysql://localhost:3306/prod";
                String connectionUser = "user01";
                String connectionPassword = "password";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                String forSql = "%" + searchString + "%";
                //sql = "select * from BOOK where AUTHOR LIKE(?)";
                stmt = conn.prepareStatement(sql); //works
                stmt.setString(1, forSql);
                rs = stmt.executeQuery(); //works

                while (rs.next()) {
                String ISBN_ID = rs.getString("ISBN_ID");
        col=0;
        data[row][col] = ISBN_ID;
        col++;
                String TITLE = rs.getString("TITLE");
        data[row][col] = TITLE;
        col++;
                String AUTHOR = rs.getString("AUTHOR");
                System.out.printf("rs: %s \n",  AUTHOR);
        data[row][col] = AUTHOR;
        col++;
                String LIBRARY_ID = rs.getString("LIBRARY_ID");
        data[row][col] = LIBRARY_ID;
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
   String[] columns = new String[] {
   "ISBN_ID", "TITLE", "AUTHOR", "LIBRARY_ID"
   };

   table = new JTable(data, columns);
   tableContainer = new JScrollPane(table);
   panel.add(tableContainer, BorderLayout.CENTER);


   f.add(panel);
   f.pack(); // Some fields of table get truncated - not sure why.
   //f.setSize(600,400);
   f.setVisible(true);

 }
}
