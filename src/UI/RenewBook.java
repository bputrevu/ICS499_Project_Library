package UI;

import DAO.PostgresDao;
import Models.BookLoan;
import Models.Transaction;

import java.time.LocalDate;

/**
 * Created by Home on 5/1/18.
 */
public class RenewBook {
    private PostgresDao pgDao;
    private BookLoan bookLoan;
    private final int maxAllowedRenewals = 3;

    public RenewBook(BookLoan bookLoan) {
        this.pgDao  = new PostgresDao();
        this.bookLoan = bookLoan;

        if (bookLoan.getRenewalCount() >= maxAllowedRenewals) {
            System.out.println("Renewal not allowed. Max Allowed Renewals are : " + maxAllowedRenewals);
        } else {
            checkForPenalty(bookLoan);
            renewAndUpdateBookLoan(bookLoan);
        }

    }

    public void renewAndUpdateBookLoan(BookLoan bookLoan) {

        bookLoan.setExpectedReturnDate(LocalDate.now().plusDays(21));
        bookLoan.setRenewalCount(bookLoan.getRenewalCount() + 1);
        String sql = "update library.bookloan "
                + " set expected_return_date = "
                + "'"
                + bookLoan.getExpectedReturnDate()
                + "'"
                + " , "
                + " renewal_count = "
                + bookLoan.getRenewalCount()
                + " where user_id = "
                + bookLoan.getUserId()
                + " and  book_id = "
                + bookLoan.getBookId()
                ;
        System.out.println("LoanBooks:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.updateRow(sql);
        createBookReturnTransaction(bookLoan.getUserId(),bookLoan.getBookId());
        pgDao.closeDbConnection();

    }

    public void createBookReturnTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "Renewed", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);
    }

    public void checkForPenalty(BookLoan bookLoan) {
        AddPenalty addPenalty = new AddPenalty(bookLoan);
    }

}
