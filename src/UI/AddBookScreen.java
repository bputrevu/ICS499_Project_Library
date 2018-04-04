package UI;
import DAO.PostgresDao;
import Models.Book;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 4/3/18.
 */
public class AddBookScreen extends JFrame {
    public AddBookScreen() {

        setLayout(new GridLayout(3,2,3,3));

        add(new JLabel("Title"));
        JTextField titleTextField = new JTextField(18);
        add(titleTextField);


        add(new JLabel("Author"));
        JTextField authorTextField = new JTextField(18);
        add(authorTextField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);
        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book = new Book(titleTextField.getText(),authorTextField.getText());
                PostgresDao pgDao = new PostgresDao();
                pgDao.createBook(book);

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBookScreen.super.dispose();
            }
        });
    }

    public void showAddBookScreen() {
        AddBookScreen addBookScreen = new AddBookScreen();
        addBookScreen.setTitle("Add Book");
        addBookScreen.setSize(350,200);
        addBookScreen.setLocationRelativeTo(null);
        addBookScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addBookScreen.setVisible(true);
    }

    public static void main(String args[])
    {
        new AddBookScreen().showAddBookScreen();
    }

}
