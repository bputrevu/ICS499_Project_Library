/*
 * puTitles.java - Uses a dialog box to list all titles and authors from MariaDB BOOK table.
 * 4-2-2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puTitles {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;

   public puTitles() {

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   String[] columns = new String[] {
        "Titles", "Authors"
        };

        titles titles_list = new titles();
        Object[][] data = titles_list.getResultSet();

        table = new JTable(data, columns);
        tableContainer = new JScrollPane(table);
        panel.add(tableContainer, BorderLayout.CENTER);

   f.add(panel);
   f.pack();
   //f.setSize(600,400);
   f.setVisible(true);
  }
 }