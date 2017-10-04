package com.twu.biblioteca.mock;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.User;

import java.util.ArrayList;

public class MockItems {
    private static Book _book;
    private static User _user;
    private static ArrayList<Book> _bookList;
    private static ArrayList<User> _userList;

    public static Book getBook() {
        if (_book == null) {
            _book = new Book("Awesome book 1", "Cool Person", 2017);
        }
        return _book;
    }

    public static ArrayList<Book> getBookList() {
        if (_bookList == null) {
            _bookList = new ArrayList<Book>() {{
                add(getBook());
                add(new Book("Awesome book 2", "Cool Person 2", 2016));
                add(new Book("Awesome book 3", "Cool Person 3", 2015));
            }};
        }
        return _bookList;
    }


    public static User getUser() {
        if (_user == null) {
            _user = new User("Alex", "alex@alex.com", "+65 9999 8888", "111-1111", "1111");
        }
        return _user;
    }

    public static ArrayList<User> getUserList() {

        if (_userList == null) {
            _userList = new ArrayList<User>() {{
                add(getUser());
                add(new User("Bobby", "bobby@bobby.com", "+65 2233 8888", "222-2222", "2222"));
                add(new User("Carrie", "carrie@carrie.com", "+65 3333 8888", "333-3333", "3333"));
            }};
        }
        return _userList;
    }

    public static String WrongBookTitle = "The True Troller book";
}
