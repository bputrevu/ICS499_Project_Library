package UI;

import DAO.PostgresDao;
import Models.BookHold;
import Models.BookLoan;
import Models.Transaction;

import java.time.LocalDate;

/**
 * Created by Home on 5/1/18.
 */
public class HoldBook {
    private PostgresDao pgDao;
    private BookHold bookHold;

    public HoldBook(BookHold bookHold) {
        this.pgDao  = new PostgresDao();
        this.bookHold = bookHold;
        createBookHold(bookHold);
    }

    public void createBookHold(BookHold bookHold) {
        String sql = "insert into library.bookhold("
                + "book_id,"
                + "user_id,"
                + "hold_create_date"
                + ")"
                + " values ("
                + bookHold.getBookId()
                +","
                + bookHold.getUserId()
                + ",'"
                + LocalDate.now()
                + "')";
        System.out.println("LoanBooks:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.insertRow(sql);
        createBookHoldTransaction(bookHold.getUserId(), bookHold.getBookId());
        pgDao.closeDbConnection();

    }

    public void createBookHoldTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "Hold", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);

    }
}
