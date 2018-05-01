package Models;

import java.time.LocalDate;

/**
 * Created by Home on 4/30/18.
 */
public class BookLoan {

    private int bookId;
    private int userId;
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private int renewalCount;

    public BookLoan(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = LocalDate.now();
        this.expectedReturnDate = this.loanDate.plusDays(21);
        this.renewalCount = 0;
    }

    public BookLoan(int bookId, int userId, LocalDate loanDate, LocalDate expectedReturnDate, int renewalCount) {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.expectedReturnDate = expectedReturnDate;
        this.renewalCount = renewalCount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public int getRenewalCount() {
        return renewalCount;
    }

    public void setRenewalCount(int renewalCount) {
        this.renewalCount = renewalCount;
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", loanDate=" + loanDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", renewalCount=" + renewalCount +
                '}';
    }
}
