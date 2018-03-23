/*
 * puAddUser.java - Testing using a dialog box to add a user to MariaDB
 * 3--18-21--2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puAddUser {
   public puAddUser() {

     JTextField field1 = new JTextField(); // How can this be changed into an int???
     JTextField field2 = new JTextField();
     JTextField field3 = new JTextField();
     JTextField field4 = new JTextField();
     JTextField field5 = new JTextField();
     JTextField field6 = new JTextField();
     Object[] message = {
         "USER_ID    ", field1,
         "CARD_ID    ", field2,
         "LAST_NAME  ", field3,
         "FIRST_NAME ", field4,
         "ADDRESS    ", field5,
         "PHONE      ", field6,

     };
     int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
     if (option == JOptionPane.OK_OPTION)
     {
         int USER_ID  = Integer.parseInt(field1.getText());
         int CARD_ID  = Integer.parseInt(field2.getText());
         String LAST_NAME = field3.getText();
         String FIRST_NAME = field4.getText();
         String ADDRESS = field5.getText();
         String PHONE = field6.getText();

         AddUser add = new AddUser();
     add.insertUser(USER_ID,CARD_ID,LAST_NAME,FIRST_NAME,ADDRESS,PHONE);

        JOptionPane.showMessageDialog(null, "You Entered \nUSER_ID" + USER_ID + "\nCARD_ID"+ CARD_ID +"\nCARD_ID"+ LAST_NAME +"\nFIRST_NAME"+ FIRST_NAME +"\nADDRESS"+ ADDRESS +"\nPHONE"+ PHONE );
     }
   }
 }