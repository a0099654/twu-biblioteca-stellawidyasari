package com.twu.biblioteca;

import com.twu.biblioteca.mock.MockItems;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    private Biblioteca _biblioteca = new Biblioteca(MockItems.getBookList());

    private User _user = MockItems.getUser();

    private String _breakline = "\n";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Before
    public void setUp() throws Exception {
        _biblioteca.login(_user.getLibraryNo(), _user.getPassword());

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void shouldFindThePositionForAvailableBookName(){
        assertEquals(-1, _biblioteca.findAvailableBooksByTitle("Awesome 2"));
    }

    @Test
    public void successAfterSuccessfulCheckout(){

        assertEquals(false, _biblioteca.checkoutBook("Awesome 2", _user.getLibraryNo()));
        assertEquals(false, _biblioteca.checkoutBook("Awesome 2", _user.getLibraryNo()));
    }

    @Test
    public void unsuccessfulAfterAnSuccessfulCheckout(){
        _biblioteca.checkoutBook(MockItems.WrongBookTitle, _user.getLibraryNo());

        assertEquals(false, _biblioteca.checkoutBook(MockItems.WrongBookTitle, _user.getLibraryNo()));
    }

    @Test
    public void unsuccessfulAfterAnUnsuccessfulReturn(){
        assertEquals(false,  _biblioteca.returnBook(MockItems.WrongBookTitle));
    }

    @Test
    public  void bookShouldBeRemovedFromBookListAfterCheckout() {
        assertEquals(false, _biblioteca.checkoutBook("Awesome 2", _user.getLibraryNo()));
    }

    @Test
    public void bookListDetailsShouldPrintedAsColumn() {
        System.setOut(null);
        String bookDetailsMock = "";
        ArrayList<Book> bookList = MockItems.getBookList();

        for (Book book : bookList){
            bookDetailsMock += book.getInfo();
        }

        assertEquals(bookDetailsMock, _biblioteca.getBookListDetails());
    }

    @Test
    public void bookShouldBeAddedToBookListAfterReturnBook(){
        Book book = MockItems.getBook();

        _biblioteca.checkoutBook(book.getTitle(), _user.getLibraryNo());
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }

    @Test
    public void shouldBeReturnTrueAfterSuccessfulReturnBook(){
        Book book = MockItems.getBook();

        assertEquals(true, _biblioteca.checkoutBook(book.getTitle(), _user.getLibraryNo()));
        assertEquals(true, _biblioteca.returnBook(book.getTitle()));
    }


    @Test
    public void userLoggedWithLibraryNumberAndPasswordWithSuccess() {
        User user = MockItems.getUser();
        assertEquals(true, _biblioteca.login(user.getLibraryNo(), user.getPassword()));
    }
}
