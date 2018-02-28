package Models;

import com.sun.tools.javac.util.List;

import java.time.LocalDate;

/**
 * Created by Home on 1/22/18.
 */
public class Book {

    private String id;
    private String title;
    private String author;
    private LocalDate dueDate;
    private User borrowdBy;
    private List<Book> holds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getBorrowdBy() {
        return borrowdBy;
    }

    public void setBorrowdBy(User borrowdBy) {
        this.borrowdBy = borrowdBy;
    }

    public List<Book> getHolds() {
        return holds;
    }

    public void setHolds(List<Book> holds) {
        this.holds = holds;
    }

    @Override
    public String toString() {
        return "Models.Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", dueDate=" + dueDate +
                ", borrowdBy=" + borrowdBy +
                ", holds=" + holds +
                '}';
    }
}
