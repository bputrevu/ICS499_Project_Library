/*
 * puMyCheckedOut.java - Uses a dialog box to list a specific users titles checked out.
 * 4-21-2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puMyCheckedOut {

 JPanel panel;
 JScrollPane tableContainer;
 JTable table;
 JFrame frame;
 String myGetID;

   //public puMyCheckedOut() {
   public puMyCheckedOut(String account) {
   myGetID = account;

   JFrame f = new JFrame("Metro Library");
   panel = new JPanel();

   String[] columns = new String[] {
        "ISBN_ID", "Titles", "Authors", "BORROWED_USER_ID", "STATUS", "DUE_DATE"
        };

        System.out.printf("puMyCheckedOut: myGetID : %s \n",  myGetID);
        //myCheckedOut outList = new myCheckedOut();
        myCheckedOut outList = new myCheckedOut(myGetID);
        //Pass User ID to MyCheckedOut.java for SQL query
        //outList.setID(myGetID);

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
