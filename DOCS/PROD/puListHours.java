/*
 * puListHours.java - Testing using a dialog box to list hours from MariaDB HOUR table.
 * 3--21--2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puListHours {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

   public puListHours() {

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   String[] columns = new String[] {
        "LIBRARY_ID", "DAY", "OPEN_HOUR", "CLOSED_HOUR"
        };

        Hours hours_list = new Hours();
        Object[][] data = hours_list.getResultSet();

        table = new JTable(data, columns);
        tableContainer = new JScrollPane(table);
        panel.add(tableContainer, BorderLayout.CENTER);

   f.add(panel);
   f.pack(); // Some fields of table get truncated - not sure why.
   //f.setSize(600,400);
   f.setVisible(true);
  }
 }
