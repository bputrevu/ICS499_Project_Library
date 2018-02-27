package Models;

import Models.Book;

import java.util.List;

/**
 * Created by Home on 1/22/18.
 */
public class User {
    private String id;
    private String name;
    private String address;
    private String phone;
    private List<Book> booksOnHold;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getBooksOnHold() {
        return booksOnHold;
    }

    public void setBooksOnHold(List<Book> booksOnHold) {
        this.booksOnHold = booksOnHold;
    }

    @Override
    public String toString() {
        return "Models.User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", booksOnHold=" + booksOnHold +
                '}';
    }
}
