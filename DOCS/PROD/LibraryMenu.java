/**
  * LibraryMenu.java
  * This class is the UI to the Metro Library application. All user and administrator functions are initiated
  * from this menu.
  * <p>
  * No parameters are sent to this class.
  * All menu functions open separate JOptionPane boxes for dialog input or display output.
  *
  * @param None accepted.
  * @return Functional dialog box.
  * @see Library System User Guide
  */


 /*
  * Last update: 3-30-2018
  */

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
    JMenuItem addUser, addBook, displayBooksTable, displayHOURSTable, displayUserTable, searchCatalogue, checkOutBook, returnBook, displayUserDoc;
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

        JMenuItem addUser =new JMenuItem("Add new user *");
        JMenuItem addBook = new JMenuItem("Add a book");
        JMenuItem displayBooksTable = new JMenuItem("Display BOOKS table *");
        JMenuItem displayHOURSTable = new JMenuItem("Display HOURS table *");
        JMenuItem displayUserTable = new JMenuItem("Display USER table *");

        JMenuItem login = new JMenuItem("Login");
        JMenuItem searchCatalogue = new JMenuItem("Search Catalog *");
        JMenuItem checkOutBook = new JMenuItem("Check out a book");
        JMenuItem returnBook = new JMenuItem("Return a book");
        JMenuItem hold = new JMenuItem("Place a Hold");
        JMenuItem displayUserDoc = new JMenuItem("Documentation *");

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
        memberMenu.add(displayUserDoc);

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

        event_displayUserDoc e6 = new event_displayUserDoc();
        displayUserDoc.addActionListener(e6);


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
        //f.setBackground(Color.yellow);
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

    public class event_displayUserDoc implements ActionListener {
        public void actionPerformed(ActionEvent e6) {
           System.out.println("displayUserDoc");
       puDocumentation puDoc = new puDocumentation();
        }
    }

    @Override
    public void run() {

    }
}
