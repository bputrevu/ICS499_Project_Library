/*
 * puAddUser.java - GUI to collect information to add a user to MariaDB.
 * Last Update4-30-2018
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puAddUser {
    String USER_ID  = null;
    String CARD_ID  = null;
    String LAST_NAME = null;
    String FIRST_NAME = null;
    String ADDRESS = null;
    String PHONE = null;
    String PASS_1 = null;
    String PASS_2 = null;

   public puAddUser() {
     JTextField field1 = new JTextField();
     JTextField field2 = new JTextField();
     JTextField field3 = new JTextField();
     JTextField field4 = new JTextField();
     JTextField field5 = new JTextField();
     JTextField field6 = new JTextField();
     JPasswordField field7 = new JPasswordField(15);
     JPasswordField field8 = new JPasswordField(15);
     Object[] message = {
         "USER_ID    ", field1,
         "PASS_1    ", field7,
         "PASS_2    ", field8,
         "CARD_ID    ", field2,
         "LAST_NAME  ", field3,
         "FIRST_NAME ", field4,
         "ADDRESS    ", field5,
         "PHONE      ", field6,
     };
     int option = JOptionPane.showConfirmDialog(null, message, "Metro Library", JOptionPane.OK_CANCEL_OPTION);
     if (option == JOptionPane.OK_OPTION)
     {
         USER_ID  = field1.getText();
         CARD_ID  = field2.getText();
         LAST_NAME = field3.getText();
         FIRST_NAME = field4.getText();
         ADDRESS = field5.getText();
         PHONE = field6.getText();
         PASS_1 = new String(field7.getPassword());
         PASS_2 = new String(field8.getPassword());

         System.out.printf("puAddUser called: Checking to see if PASS_1 equals PASS_2. PASS_1 %s, PASS_2 %s \n",  PASS_1, PASS_2);
        //Check that both password fields match. If they do, ok to add information, if they don't send an error message to have them reenter password.
        if (PASS_1.equals(PASS_2)){
            System.out.printf("puAddUser: PASS_1 equals PASS_2, calling AddUser. )  %s \n",  PASS_1);
            AddUser add = new AddUser();
            add.insertUser(USER_ID,CARD_ID,LAST_NAME,FIRST_NAME,ADDRESS,PHONE,PASS_1);
            JOptionPane.showMessageDialog(null, "You Entered \nUSER_ID:  " + USER_ID + "\nCARD_ID:  "+ CARD_ID +"\nCARD_ID:  "+ LAST_NAME +"\nFIRST_NAME:  "+ FIRST_NAME +"\nADDRESS:  "+ ADDRESS +"\nPHONE:  "+ PHONE );
        } else {
            JOptionPane.showMessageDialog(null, "Passwords do not match! Please try again.");
            System.out.printf("puAddUser: PASS_1 does not equal PASS_2. PASS_1 %s, PASS_2 %s \n",  PASS_1, PASS_2);
            puAddUser puAdd = new puAddUser();
          }
       }
    }
 }
