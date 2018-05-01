package UI;

import DAO.PostgresDao;
import Models.BookHold;
import Models.Transaction;

import java.time.LocalDate;

/**
 * Created by Home on 5/1/18.
 */
public class RemoveHold {
    private PostgresDao pgDao;
    private BookHold bookHold;

    public RemoveHold(BookHold bookHold) {
        this.pgDao  = new PostgresDao();
        this.bookHold = bookHold;
        removeBookHold(bookHold);
    }

    public void removeBookHold(BookHold bookHold) {
        String sql = "delete from  library.bookhold "
                + " where "
                + " book_id = "
                + bookHold.getBookId()
                + " and user_id = "
                + bookHold.getUserId()
                ;
        System.out.println("LoanBooks:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.deleteRow(sql);
        createRemoveBookHoldTransaction(bookHold.getUserId(), bookHold.getBookId());
        pgDao.closeDbConnection();

    }

    public void createRemoveBookHoldTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "RemoveHold", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);

    }
}
