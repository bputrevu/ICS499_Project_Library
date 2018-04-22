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
  * Last update: 4-22-2018
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
    JMenuItem addUser, addBook, displayBooksOutTable, displayHOURSTable, displayUserTable, searchCatalogue, checkOutBook, myCheckOutBook, logout, displayUserDoc, listAllTitles, SystemImgDoc;
    JPanel panel;
    JScrollPane tableContainer;
    JTable table, hoursTable;
    JFrame frame;
    String myGetID;


    LibraryMenu(){
        JFrame f= new JFrame("Library");
        JMenuBar mb=new JMenuBar();

        //Setup Menu
        libraryMenu = new JMenu("Menu");
        adminMenu = new JMenu("Admin Functions");
        memberMenu = new JMenu("My Metro Library");

        JMenuItem addUser =new JMenuItem("Add new user *");
        JMenuItem addBook = new JMenuItem("Add a book");
        JMenuItem displayBooksOutTable = new JMenuItem("Display books checked out *");
        JMenuItem displayHOURSTable = new JMenuItem("Display HOURS table *");
        JMenuItem displayUserTable = new JMenuItem("Display USER table *");
        JMenuItem SystemImgDoc = new JMenuItem("System Implementation Doc *");

        JMenuItem searchCatalogue = new JMenuItem("Search Catalog *");
        JMenuItem listAllTitles = new JMenuItem("List all titles *");
        JMenuItem checkOutBook = new JMenuItem("Check-in or Check-out a book **");
        JMenuItem hold = new JMenuItem("Place a Hold");
        JMenuItem displayUserDoc = new JMenuItem("Documentation *");
        JMenuItem myCheckOutBook = new JMenuItem("My Checked out Books ** ");
        JMenuItem logout = new JMenuItem("Logout of My Metro Library **");

        adminMenu.add(addUser);
        adminMenu.add(addBook);
        adminMenu.add(displayBooksOutTable);
        adminMenu.add(displayHOURSTable);
        adminMenu.add(displayUserTable);
        adminMenu.add(SystemImgDoc);

        memberMenu.add(searchCatalogue);
        memberMenu.add(listAllTitles);
        memberMenu.add(myCheckOutBook);
        memberMenu.add(checkOutBook);
        memberMenu.add(hold);
        memberMenu.add(displayUserDoc);
        memberMenu.add(logout);

        event_displayBooksOutTable e1 = new event_displayBooksOutTable();
        displayBooksOutTable.addActionListener(e1);

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

        event_checkOutBook e7 = new event_checkOutBook();
        checkOutBook.addActionListener(e7);

        event_listAllTitles e8 = new event_listAllTitles();
        listAllTitles.addActionListener(e8);

        event_SystemImgDoc e9 = new event_SystemImgDoc();
        SystemImgDoc.addActionListener(e9);

        event_myCheckOutBook e10 = new event_myCheckOutBook();
        myCheckOutBook.addActionListener(e10);

        event_logout e11 = new event_logout();
        logout.addActionListener(e11);

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
    }
    public static void main(String args[])
    {
        new LibraryMenu();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class event_displayBooksOutTable implements ActionListener {
        public void actionPerformed(ActionEvent e1) {
           System.out.println("event_displayBooksOutTable");
           //JOptionPane.showMessageDialog(null, "event_displayBooksTable ");

        puCheckedOut puList = new puCheckedOut();
        }
    }

    public class event_displayHOURSTable implements ActionListener {
        public void actionPerformed(ActionEvent e2) {
           System.out.println("event_displayHOURSTable");
           //JOptionPane.showMessageDialog(null, "event_displayHOURSTable ");
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

    public class event_checkOutBook implements ActionListener {
        public void actionPerformed(ActionEvent e7) {
          System.out.println("checkOutBook");
          System.out.printf("ID : %s \n",  myGetID);
          puCheckBook checkBook = new puCheckBook(myGetID);
        }
    }

    public class event_listAllTitles implements ActionListener {
        public void actionPerformed(ActionEvent e8) {
           System.out.println("listAllTitles");
       puTitles checkBook = new puTitles();
        }
    }

    public class event_SystemImgDoc implements ActionListener {
        public void actionPerformed(ActionEvent e9) {
           System.out.println("puSystemImgDoc");
       puSystemImgDoc sysDoc = new puSystemImgDoc();
        }
    }

    public class event_myCheckOutBook implements ActionListener {
        public void actionPerformed(ActionEvent e10) {
         System.out.println("event_myCheckOutBook");
         //JOptionPane.showMessageDialog(null, "event_myCheckOutBook ");
         System.out.println("myCheckOutBook");
         System.out.printf("ID : %s \n",  myGetID);
         puMyCheckedOut puList = new puMyCheckedOut(myGetID);
        }
    }

    public class event_logout implements ActionListener {
        public void actionPerformed(ActionEvent e11) {
         System.out.println("event_logout");
         //JOptionPane.showMessageDialog(null, "event_logout ");
         System.out.printf("ID : %s \n",  myGetID);
         System.out.println("Exiting....");
         System.exit(0);
        }
    }

 // User-ID is passed from launch.java to this menu instance.
    public void setID(String account) {
      myGetID = account;
      session trackID = new session();
      trackID.setID(myGetID);
      String getID = trackID.getID();
      System.out.printf("getID : %s \n",  getID);
    }


    @Override
    public void run() {

    }
}
