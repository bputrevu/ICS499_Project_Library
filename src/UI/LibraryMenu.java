package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Home on 2/27/18.
 */

public class LibraryMenu implements Runnable, ActionListener
{
    JMenu libraryMenu, adminMenu, memberMenu;

    JMenuItem addUser, addBook, searchCatalogue, checkOutBook, returnBook;


    LibraryMenu(){
        JFrame f= new JFrame("Library");
        JMenuBar mb=new JMenuBar();

        libraryMenu = new JMenu("Menu");
        adminMenu = new JMenu("Admin Functions");
        memberMenu = new JMenu("Models.User Functions");

        JMenuItem addUser =new JMenuItem("Add new user");
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  AddUserScreen().showAddUserScreen();
            }
        });
        JMenuItem addBook = new JMenuItem("Add a book");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookScreen().showAddBookScreen();
            }
        });

        JMenuItem login = new JMenuItem("Login");
        JMenuItem searchCatalogue = new JMenuItem("Search Catalogue");
        JMenuItem checkOutBook = new JMenuItem("Check out a book");
        JMenuItem returnBook = new JMenuItem("Return a book");
        JMenuItem hold = new JMenuItem("Place a Hold");

        adminMenu.add(addUser);
        adminMenu.add(addBook);

        memberMenu.add(login);
        memberMenu.add(searchCatalogue);
        memberMenu.add(checkOutBook);
        memberMenu.add(returnBook);
        memberMenu.add(hold);

        libraryMenu.add(adminMenu);
        libraryMenu.add(memberMenu);

        mb.add(libraryMenu);

        f.setJMenuBar(mb);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new LibraryMenu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
