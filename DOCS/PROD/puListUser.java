/*
 * puListUser.java - Testing using a dialog box to list users from MariaDB USER table.
 * 3--21--2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puListUser {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

   public puListUser() {

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   String[] columns = new String[] {
   "USER_ID", "CARD_ID", "LAST_NAME", "FIRST_NAME", "ADDRESS","PHONE"
   };

   User user_list = new User();
   Object[][] data = user_list.getResultSet();

   table = new JTable(data, columns);
   tableContainer = new JScrollPane(table);
   panel.add(tableContainer, BorderLayout.CENTER);

   f.add(panel);
   f.pack(); // Some fields of table get truncated - not sure why.
   //f.setSize(600,400);
   f.setVisible(true);
  }
 }
