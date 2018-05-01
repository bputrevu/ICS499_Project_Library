package UI;

import DAO.PostgresDao;
import Models.BookLoan;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Home on 5/1/18.
 */
public class AddPenalty {
    private PostgresDao pgDao;
    private BookLoan bookLoan;
    private final double penaltyPerDay = 0.05;

    public AddPenalty(BookLoan bookLoan) {
        this.pgDao  = new PostgresDao();
        this.bookLoan = bookLoan;
        if (bookLoan.getExpectedReturnDate().isBefore(LocalDate.now())) {
            addPenaltyForUser();
        }
    }

    public void addPenaltyForUser() {
        Period p = Period.between(LocalDate.now(),bookLoan.getExpectedReturnDate());
        double penalty = Math.abs(p.getDays())  * penaltyPerDay;
        System.out.println("Late by: " + Math.abs(p.getDays()) + " Penalty: " + penalty);

        String sql = "update library.user "
                + " set outstanding_penalty_fees = outstanding_penalty_fees +  "
                + penalty
                + " where user_id = "
                + bookLoan.getUserId()
                ;
        System.out.println("LoanBooks:  Sql:" + sql);

        pgDao.openDbConnection();
        pgDao.updateRow(sql);
        pgDao.closeDbConnection();


    }
}
