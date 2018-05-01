package Models;

import java.time.LocalDate;

/**
 * Created by Home on 5/1/18.
 */
public class Transaction {
    private int transactionId;
    private LocalDate transactionDate;
    private int userId;
    private String transactionType;
    private int bookId;

    public Transaction(LocalDate transactionDate, int userId, String transactionType, int bookId) {
        this.transactionDate = transactionDate;
        this.userId = userId;
        this.transactionType = transactionType;
        this.bookId = bookId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionDate=" + transactionDate +
                ", userId=" + userId +
                ", transactionType='" + transactionType + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
