package DAO;

import Models.Book;
import Models.BookLoan;
import Models.BookLoanList;
import Models.User;
import UI.LoanBooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Home on 4/3/18.
 */
public class PostgresDao {

    private Connection c;
    private Statement stmt;
    private ResultSet rs;

    public PostgresDao() {
        Connection c = null;
        stmt = null;
        rs = null;
    }

    public void  openDbConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/library",
                            "Home", "");
            stmt = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void closeDbConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Closed database successfully");

    }

    public void insertRow(String sql) {
        try {
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    public ResultSet selectQuery(String sql) {
        try {
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records fetched successfully");
        return rs;
    }

    public void createUser(User user) {
        String sql = "insert into library.user("
                + "first_name,"
                + "last_name,"
                + "address_line1,"
                + "address_line2,"
                + "phone"
                + ")"
                + " values ("
                +"'"
                + user.getFirstName()
                + "','"
                +user.getLastName()
                + "','"
                +user.getAddressLine1()
                + "','"
                +user.getAddressLine2()
                + "','"
                +user.getPhone()
                + "')";

        System.out.println("Sql:" + sql);
        openDbConnection();
        insertRow(sql);
        closeDbConnection();
    }

    public void createBook(Book book) {
        String sql = "insert into library.book("
                + "title,"
                + "author"
                + ")"
                + " values ("
                +"'"
                + book.getTitle()
                + "','"
                +book.getAuthor()
                + "')";

        System.out.println("Sql:" + sql);
        openDbConnection();
        insertRow(sql);
        closeDbConnection();
    }


    public void testInsertUser(PostgresDao pgDao){

        pgDao.openDbConnection();
        String sql = "insert into library.user("
                + "first_name,"
                + "last_name,"
                + "address_line1,"
                + "address_line2,"
                + "phone"
                + ")"
                + " values ("
                + "'John',"
                + "'Hagger',"
                + "'8692 Olive Ln N',"
                + "'Eagan, MN 55432',"
                + "'651-442-5361'"
                + ")";

        System.out.println("Sql:" + sql);
        pgDao.insertRow(sql);
    }

    public void testSelectUser(PostgresDao pgDao) {

        pgDao.openDbConnection();

        String sql1 = "Select "
                + "user_id, "
                + "first_name, "
                + "last_name, "
                + "address_line1, "
                + "address_line2, "
                + "phone "
                + "from  library.user "
             //   + "where phone = '651-442-5361'"
                ;
        System.out.println("Sql1:" + sql1);

        try {
            ResultSet rs = pgDao.selectQuery(sql1);
            while ( rs.next() ) {
                String  user_id = rs.getString("user_id");
                String  first_name = rs.getString("first_name");
                String  last_name = rs.getString("last_name");
                String  address_line1 = rs.getString("address_line1");
                String  address_line2 = rs.getString("address_line2");
                String  phone = rs.getString("phone");
                System.out.print(user_id);
                System.out.print(" ");
                System.out.print(first_name);
                System.out.print(" ");
                System.out.print(last_name);
                System.out.print(" ");
                System.out.print(address_line1);
                System.out.print(" ");
                System.out.print(address_line2);
                System.out.print(" ");
                System.out.print(phone);
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        pgDao.closeDbConnection();
    }

    public void testInsertBookLoan(){

    }

    public static void main(String args[]) {
        PostgresDao pgDao = new PostgresDao();
        pgDao.testSelectUser(pgDao);
        //pgDao.testInsertUser(pgDao);

        BookLoanList bookLoanList = new BookLoanList();
        BookLoan bookLoan1 = new BookLoan(5,1);
        BookLoan bookLoan2 = new BookLoan(6,1);
        bookLoanList.addBookToList(bookLoan1);
        bookLoanList.addBookToList(bookLoan2);

        LoanBooks loanBooks = new LoanBooks();
        loanBooks.insertBookLoan(bookLoanList);

    }
}
