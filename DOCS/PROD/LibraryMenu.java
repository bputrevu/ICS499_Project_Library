//package UI;
// 3-17,18-2018 - add MariaDB tables to menue - problems with display.
//

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *  * Created by Home on 2/27/18.
 *   */

public class LibraryMenu implements Runnable, ActionListener
{
    JMenu libraryMenu, adminMenu, memberMenu;
    JMenuItem addUser, addBook, displayBooksTable, displayHOURSTable, displayUserTable, searchCatalogue, checkOutBook, returnBook;
    JPanel panel;
    JScrollPane tableContainer;
    JTable table, hoursTable;
    JFrame frame;


    LibraryMenu(){
        JFrame f= new JFrame("Library");
        JMenuBar mb=new JMenuBar();

        libraryMenu = new JMenu("Menu");
        adminMenu = new JMenu("Admin Functions");
        memberMenu = new JMenu("Models.User Functions");

        JMenuItem addUser =new JMenuItem("Add new user");
        JMenuItem addBook = new JMenuItem("Add a book");
        JMenuItem displayBooksTable = new JMenuItem("Display BOOKS table");
        JMenuItem displayHOURSTable = new JMenuItem("Display HOURS table");
        JMenuItem displayUserTable = new JMenuItem("Display USER table");

        JMenuItem login = new JMenuItem("Login");
        JMenuItem searchCatalogue = new JMenuItem("Search Catalog");
        JMenuItem checkOutBook = new JMenuItem("Check out a book");
        JMenuItem returnBook = new JMenuItem("Return a book");
        JMenuItem hold = new JMenuItem("Place a Hold");

        adminMenu.add(addUser);
        adminMenu.add(addBook);
        adminMenu.add(displayBooksTable);
        adminMenu.add(displayHOURSTable);
        adminMenu.add(displayUserTable);

        memberMenu.add(login);
        memberMenu.add(searchCatalogue);
        memberMenu.add(checkOutBook);
        memberMenu.add(returnBook);
        memberMenu.add(hold);

        event_displayBooksTable e1 = new event_displayBooksTable();
        displayBooksTable.addActionListener(e1);

        event_displayHOURSTable e2 = new event_displayHOURSTable();
        displayHOURSTable.addActionListener(e2);

        event_displayUserTable e3 = new event_displayUserTable();
        displayUserTable.addActionListener(e3);

        event_addUser e4 = new event_addUser();
        addUser.addActionListener(e4);

        event_searchCatalogue e5 = new event_searchCatalogue();
        searchCatalogue.addActionListener(e5);



        panel = new JPanel(); //me

        libraryMenu.add(adminMenu);
        libraryMenu.add(memberMenu);
        libraryMenu.add(panel); // me

        mb.add(libraryMenu);

        f.setJMenuBar(mb);
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Metro Library");
        //f.setLocationRelativeTo(null);
    }
    public static void main(String args[])
    {
        new LibraryMenu();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class event_displayBooksTable implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
           System.out.println("event_displayBooksTable");
           //JOptionPane.showMessageDialog(null, "event_displayBooksTable ");

        puListBooks puList = new puListBooks();


        }
    }

    public class event_displayHOURSTable implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
           System.out.println("event_displayHOURSTable");
           //JOptionPane.showMessageDialog(null, "event_displayHOURSTable ");
           //
        puListHours puList = new puListHours();
        }
    }

    public class event_displayUserTable implements ActionListener {
        public void actionPerformed(ActionEvent e3) {
           System.out.println("event_displayUserTable");
           //JOptionPane.showMessageDialog(null, "event_displayUserTable ");

        puListUser puList = new puListUser();

        }
    }


    public class event_addUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e4) {
           System.out.println("event_addUser");
           //JOptionPane.showMessageDialog(null, "event_addUser ");
           puAddUser puAdd = new puAddUser();
        }
    }

    public class event_searchCatalogue implements ActionListener {
        public void actionPerformed(ActionEvent e5) {
           System.out.println("event_searchCatalogue");
       puSearchBook puSearch = new puSearchBook();

        }
    }


    @Override
    public void run() {

    }
}
