/**
 * puAddUser.java
 * This class, as used with he Metro Library application, is called by the library GUI menu (LibraryMenu.java)
 * in order to launch a JoptionPane dialog box for administrators to add new user-id's for user access.
 * <p>
 * This class excepts 6 parameters for user-id setup and calls AddUser.java which inserts the record into
 * the backend database service.
 *
 * @param USER_ID     INT - unique numeric ID for user access.
 * @param CARD_ID     INT - unique numeric ID for user card(s).
 * @param LAST_NAME   String - Last name of account holder.
 * @param FIRST_NAME  String - First name of account holder.
 * @param ADDRESS     String - Full address of account holder.
 * @param PHONE       String - Phone number of account holder.
 * @return Account information in dialog box.
 * @see Library System User Guide
 */
 
/*
 * Last Update: 3-22-2018
 */

import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

public class puAddUser {
    public puAddUser() {
        JTextField field1 = new JTextField();
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

        int userId;
        String lastName;
        String firstName;
        String address;
        String phone;
        //Add validations
        boolean validInput = true;
        try {
            userId = Integer.parseInt(field1.getText());
            lastName = field3.getText();
            firstName = field4.getText();
            address = field5.getText();
            phone = field6.getText();
        } catch (Exception e) {
            validInput = false;
            e.printStackTrace();
        }

        int option = JOptionPane.showConfirmDialog(null, message, "Metro Library System: User-id Setup", JOptionPane.OK_CANCEL_OPTION);

        if (validInput) {
            if (option == JOptionPane.OK_OPTION) {
                AddUser newUser = new AddUser(userId,lastName,firstName,address,phone);
                newUser.insertUser();

                JOptionPane.showMessageDialog(null, "Account Record:  \nUSER_ID:  " + USER_ID + "\nCARD_ID:  " + CARD_ID + "\nCARD_ID:  " + LAST_NAME + "\nFIRST_NAME:  " + FIRST_NAME + "\nADDRESS:  " + ADDRESS + "\nPHONE:  " + PHONE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid input");
        }
    }
}