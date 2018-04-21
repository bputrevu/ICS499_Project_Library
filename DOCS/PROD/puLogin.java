/*
 * puLogin.java - Dialog box to login to the Metro Library application.
 * 4-21-2018 - Modify to use session.java to track which user is logged in.
 * 3-30-2018 - Original login program.
 */

 import javax.swing.JOptionPane;
 import java.awt.*;
 import javax.swing.*;

 public class puLogin {
   public puLogin() {

     JTextField field1 = new JTextField(15);
     JPasswordField field2 = new JPasswordField(15);
     Object[] message = {
         "USER_ID    ", field1,
         "PASSWORD    ", field2,

     };
     int option = JOptionPane.showConfirmDialog(null, message, "Metro Library", JOptionPane.OK_CANCEL_OPTION);
     if (option == JOptionPane.OK_OPTION)
     {

         String USER_ID = field1.getText();
         String PASSWORD = new String(field2.getPassword());

         //Temporary until database is used to authenticate
         String ID_database = "user01";
         String PASS_database = "pass01";

        //Authenticate.
        //Launch LibraryMenu (application) if valid account or else
        //Redirect user to login again.
        if (ID_database.equals(USER_ID) && PASS_database.equals(PASSWORD)){
            // Save user ID in a session class.
            //session trackID = new session();
            //trackID.setID(USER_ID);

            // Acknowledge successful login.
            JOptionPane.showMessageDialog(null, "Authenticated");
            LibraryMenu app = new LibraryMenu();
            app.setID(USER_ID);
        } else {
            JOptionPane.showMessageDialog(null, "User ID or password is incorrect.");
            puLogin login = new puLogin();
          }
     }
   }
 }
