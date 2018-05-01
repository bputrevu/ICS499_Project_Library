package UI;
import DAO.PostgresDao;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 4/3/18.
 */
public class AddUserScreen extends JFrame {
    public AddUserScreen() {
        //setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        setLayout(new GridLayout(6,3,3,3));

        add(new JLabel("First Name"));
        JTextField firstNameTextField = new JTextField(18);
        add(firstNameTextField);


        add(new JLabel("Last Name"));
        JTextField lastNameTextField = new JTextField(18);
        add(lastNameTextField);

        add(new JLabel("Address Line 1"));
        JTextField addressLine1TextField = new JTextField(18);
        add(addressLine1TextField);

        add(new JLabel("Address Line 2"));
        JTextField addressLine2TextField = new JTextField(18);
        add(addressLine2TextField);

        add(new JLabel("Phone"));
        JTextField phoneTextField = new JTextField(18);
        add(phoneTextField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);
        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);
//        JButton returnButton = new JButton("Return");
//        add(returnButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(firstNameTextField.getText(),lastNameTextField.getText(),addressLine1TextField.getText(),addressLine2TextField.getText(),phoneTextField.getText());
                PostgresDao pgDao = new PostgresDao();
                pgDao.createUser(user);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserScreen.super.dispose();
            }
        });
    }

    public void showAddUserScreen() {
        AddUserScreen addUserScreen = new AddUserScreen();
        addUserScreen.setTitle("Add User");
        addUserScreen.setSize(350,200);
        addUserScreen.setLocationRelativeTo(null);
        addUserScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUserScreen.setVisible(true);
    }

    public static void main(String args[])
    {
        new AddUserScreen().showAddUserScreen();
    }

}
