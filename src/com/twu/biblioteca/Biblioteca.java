package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    public ArrayList<Book> _bookList =  new ArrayList<Book>();

    public ArrayList<Book> _checkedOutBooks = new ArrayList<Book>();

    public ArrayList<User> _userList = new ArrayList<User>();

    public User _userLogged;


    public Biblioteca(ArrayList<Book> books) {
        _bookList = new ArrayList<Book>();

        addBookItems(books);
        addUsers();

    }

    public void addBookItems(ArrayList<Book> books){
        for (Book book : books){
            _bookList.add(new Book(book.getTitle(), book.getAuthor(), book.getYear()));
        }
    }

    public void addUsers(){
        _userList = new ArrayList<User>() {{
            add(new User("Alex", "alex@alex.com", "+65 9999 8888", "111-1111", "1111"));
            add(new User("Bobby", "bobby@bobby.com", "+65 2233 8888", "222-2222", "2222"));
            add(new User("Carrie", "carrie@carrie.com", "+65 3333 8888", "333-3333", "3333"));
        }};

    }

    public String getBookListDetails(){
        String booksLists = "";

        for(Book book: _bookList){
            if(!book.isSelected){
                booksLists += book.getInfo();
            }
        }

        return booksLists;
    }

    public boolean checkoutBook(String bookTitle, String libraryNo){
        int position = findAvailableBooksByTitle(bookTitle);

        if (position != -1) {
            Book book = _bookList.get(position);
            book.isSelected = true;
            book.setUserLibraryNumber(libraryNo);
            _checkedOutBooks.add(book);
            _bookList.remove(position);

            return true;
        }
        return false;
    }

    public boolean returnBook(String bookTitle){
        int position = findCheckedOutBooksByTitle(bookTitle);

        if(position != -1){
            _checkedOutBooks.get(position).isSelected = false;
            _bookList.add(_checkedOutBooks.get(position));

            _checkedOutBooks.remove(position);

             return true;
        }

        return false;

    }

    public boolean login(String libraryNo, String password) {
        int position = findUsersByLibraryNumberAndPassword(libraryNo, password);
        if (position != - 1) {
            _userList.get(position).isLogged = true;
            _userLogged = _userList.get(position);
            return true;
        }
        return false;
    }


    public int findCheckedOutBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _checkedOutBooks);
    }

    public int findAvailableBooksByTitle(String bookTitle){
        return findBooksByTitle(bookTitle, _bookList);
    }

    public int findBooksByTitle(String bookTitle, ArrayList<Book> bookList){
        int i = 0;
        int position = -1;

        for (Book book : bookList){
            if(book.getTitle().equals(bookTitle)){
                position = i;
                break;
            }
            i++;
        }
        return position;
    }

    public User getUserLogged(){
        return _userLogged;
    }

    public String getUserLoggedDetails(){
        return _userLogged.getInfo();
    }

    public boolean logout(String libraryNo, String password) {
        int position = findUsersByLibraryNumberAndPassword(libraryNo, password);
        if (position != - 1) {
            _userList.get(position).isLogged = false;
            _userLogged = null;
            return true;
        }
        return false;
    }

    public int findUsersByLibraryNumberAndPassword(String libraryNo, String password){
        int i = 0;
        int position = -1;

        for (User user : _userList){
            if(user.checkCredential(libraryNo, password)){
                position = i;
                break;
            }
            i++;
        }
        return position;
    }


}
