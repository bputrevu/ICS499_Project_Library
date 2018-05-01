package UI;

import DAO.PostgresDao;
import Models.BookLoan;
import Models.BookLoanList;
import Models.Transaction;

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

    public void insertBookLoan(BookLoanList bookLoanList) {
        boolean gotLoanedBookCount = false;
        int totalLoanedBooks = 0;
        ListIterator<BookLoan> listIter = bookLoanList.getBookLoanListIterator();
        while (listIter.hasNext()) {
            BookLoan bookLoan = listIter.next();
            if (!gotLoanedBookCount) {
                totalLoanedBooks = getLoanedBookCount(bookLoan.getUserId());
                gotLoanedBookCount = true;
            }
            totalLoanedBooks++;

                String sql = "insert into library.bookloan("
                        + "book_id,"
                        + "user_id,"
                        + "loaned_date,"
                        + "expected_return_date,"
                        + "renewal_count"
                        + ")"
                        + " values ("
                        + "'"
                        + bookLoan.getBookId()
                        + "','"
                        + bookLoan.getUserId()
                        + "','"
                        + bookLoan.getLoanDate()
                        + "','"
                        + bookLoan.getExpectedReturnDate()
                        + "','"
                        + bookLoan.getRenewalCount()
                        + "')";
                System.out.println("LoanBooks:  Sql:" + sql);

                pgDao.openDbConnection();
                pgDao.insertRow(sql);
                pgDao.closeDbConnection();

        }
    }

    public int getLoanedBookCount(int userId) {
        int loanedBookCount = 0;
        String sql = "Select Count(*) as rowcount "
                + "from  library.bookloan "
                + "where user_id = "
                + userId;
        System.out.println("sql" + sql);
        pgDao.openDbConnection();
        ResultSet rs = pgDao.selectQuery(sql);
        try {
            while (rs.next()) {
                loanedBookCount = Integer.parseInt(rs.getString("rowcount"));
                System.out.println("loanedBookCount: " + loanedBookCount);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        pgDao.closeDbConnection();
        return loanedBookCount;
    }

    public void createBookReturnTransaction(int userId, int bookId) {
        Transaction transaction = new Transaction(LocalDate.now(), userId, "Returned", bookId);
        CreateTransaction createTransaction = new CreateTransaction(transaction);

    }
}
