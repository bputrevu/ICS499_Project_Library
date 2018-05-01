package UI;

import DAO.PostgresDao;
import Models.BookLoan;
import Models.BookLoanList;

import java.sql.ResultSet;
import java.util.ListIterator;

/**
 * Created by Home on 4/30/18.
 */
public class LoanBooks {
    private PostgresDao pgDao;
    private final int maxAllowedLoanedBooks = 5;

    public LoanBooks() {
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
            if (totalLoanedBooks <= maxAllowedLoanedBooks) {
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
            } else {
                System.out.println("User has already loaned max allowed books. Cannot loan anymore");
            }
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
}
