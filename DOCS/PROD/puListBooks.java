/*
 * puListBooks.java - Testing using a dialog box to list books from MariaDB BOOK table.
 * 3--21--2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puListBooks {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

   public puListBooks() {

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columns = new String[] {
        "ISBN_ID", "Title", "Author", "LIBRARY_ID", "BORROWED_USER_ID","DUE_DATE"
        };

        Book list = new Book();
        Object[][] data = list.getResultSet();

        table = new JTable(data, columns);
        tableContainer = new JScrollPane(table);

   f.add(panel);
   f.pack(); // Some fields of table get truncated - not sure why.
   //f.setSize(600,400);
   f.setVisible(true);
  }
 }
