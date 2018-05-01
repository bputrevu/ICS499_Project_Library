package Models;

import java.time.LocalDate;

/**
 * Created by Home on 5/1/18.
 */
public class BookHold {
    private int bookId;
    private int userId;
    private LocalDate holdCreateDate;
    private LocalDate heldUntilDate;

    public BookHold(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.holdCreateDate = LocalDate.now();
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

    public LocalDate getHoldCreateDate() {
        return holdCreateDate;
    }

    public void setHoldCreateDate(LocalDate holdCreateDate) {
        this.holdCreateDate = holdCreateDate;
    }

    public LocalDate getHeldUntilDate() {
        return heldUntilDate;
    }

    public void setHeldUntilDate(LocalDate heldUntilDate) {
        this.heldUntilDate = heldUntilDate;
    }

    @Override
    public String toString() {
        return "BookHold{" +
                "bookId=" + bookId +
                ", userId=" + userId +
                ", holdCreateDate=" + holdCreateDate +
                ", heldUntilDate=" + heldUntilDate +
                '}';
    }
}
