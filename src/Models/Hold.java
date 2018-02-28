package Models;

import java.time.LocalDate;

/**
 * Created by Home on 2/27/18.
 */
public class Hold {
    private String bookId;
    private String userId;
    private LocalDate holdDate;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(LocalDate holdDate) {
        this.holdDate = holdDate;
    }


    public Hold(String bookId, String userId, LocalDate holdDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.holdDate = holdDate;
    }

    @Override
    public String toString() {
        return "Hold{" +
                "bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", holdDate=" + holdDate +
                '}';
    }
}
