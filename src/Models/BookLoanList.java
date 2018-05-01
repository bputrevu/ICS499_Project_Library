package Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Home on 4/30/18.
 */
public class BookLoanList {

    private List<BookLoan> bookLoanList;

    public BookLoanList() {
        this.bookLoanList = new ArrayList<BookLoan>();
    }

    public void addBookToList(BookLoan bookLoan) {
     this.bookLoanList.add(bookLoan);
    }

    public List<BookLoan> getBookLoanList() {
        return bookLoanList;
    }

    public void setBookLoanList(List<BookLoan> bookLoanList) {
        this.bookLoanList = bookLoanList;
    }

    public ListIterator<BookLoan> getBookLoanListIterator() {
        return bookLoanList.listIterator();
    }
}
