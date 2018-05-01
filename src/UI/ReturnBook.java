package UI;

import DAO.PostgresDao;
import Models.BookLoan;
import Models.BookLoanList;
import Models.Transaction;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ListIterator;

/**
 * Created by Home on 5/1/18.
 */
public class ReturnBook {
    private PostgresDao pgDao;

    public ReturnBook() {
        this.pgDao  = new PostgresDao();
    }

    public void deleteBookLoan(BookLoan bookLoan) {

        String sql = "delete  from  library.bookloan "
                + " where "
                + "book_id = "
                + bookLoan.getBookId()
                + " and user_id = "
                + bookLoan.getUserId()
                ;
        System.out.println("LoanBooks:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.deleteRow(sql);
        pgDao.closeDbConnection();

        createBookReturnTransaction(bookLoan.getUserId(),bookLoan.getBookId());
    }


    public void createBookReturnTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "Returned", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);

    }

    public void createPenaltyTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "Penalty", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);

    }
}
