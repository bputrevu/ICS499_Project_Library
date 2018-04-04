/*
 * puCheckedOut.java - Uses a dialog box to list all titles cheked out by users.
 * 4-2-2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puCheckedOut {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

   public puCheckedOut() {

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   String[] columns = new String[] {
        "ISBN_ID", "Titles", "Authors", "BORROWED_USER_ID", "STATUS", "DUE_DATE"
        };

        checkedOut outList = new checkedOut();
        Object[][] data = outList.getResultSet();

        table = new JTable(data, columns);
        tableContainer = new JScrollPane(table);
        panel.add(tableContainer, BorderLayout.CENTER);

   f.add(panel);
   f.pack();
   //f.setSize(600,400);
   f.setVisible(true);
  }
 }