package Models;

import com.sun.tools.javac.util.List;

/**
 * Created by Home on 2/27/18.
 */
public class Library {

    private List<Book> bookList;
    private List<User> userList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Library(List<Book> bookList, List<User> userList) {
        this.bookList = bookList;
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", userList=" + userList +
                '}';
    }
}
