package com.twu.biblioteca;

import com.twu.biblioteca.mock.MockItems;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private Biblioteca _biblioteca = new Biblioteca(MockItems.getBookList());

    private User user = MockItems.getUser();

    private ArrayList<User> _userList = MockItems.getUserList();

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }


    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void userShouldBeLoggedWhenPassingCorrectInformation() {
        _biblioteca.login(user.getLibraryNo(), user.getPassword());
        User userLogged = _biblioteca.getUserLogged();
        assertEquals(true, userLogged.isLogged);
        assertEquals(true, userLogged.getInfo().equals(user.getInfo()));
        assertEquals(true, userLogged.getEmail().equals(user.getEmail()));
        assertEquals(true, userLogged.getLibraryNo().equals(user.getLibraryNo()));
        assertEquals(true, userLogged.getPassword().equals(user.getPassword()));
        assertEquals(true, userLogged.checkCredential(user.getLibraryNo(), user.getPassword()));
    }


    @Test
    public void printUserDetailsShouldPrintNameEmailPhoneOnColumns() throws Exception {

        Random random = new Random();

        User generativeUser = _userList.get(random.nextInt(_userList.size()));
        String userDetails = generativeUser.getInfo();

        assertEquals(userDetails.isEmpty(), false);


        String[] books = userDetails.split("\n");


        assertEquals(books.length, 6);

        assertEquals(true, userDetails.contains(generativeUser.getName()));
        assertEquals(true, userDetails.contains(generativeUser.getEmail()));
        assertEquals(true, userDetails.contains(generativeUser.getPhone()));
    }

    @Test
    public void userShouldBeReturnFalseWhenPassIncorrectInformation() {
        _biblioteca.login("Something else", user.getPassword());
        User userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);

        _biblioteca.login(user.getLibraryNo() ,"Something else");
        userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);

        _biblioteca.login("Something else", "Something else");
        userLogged = _biblioteca.getUserLogged();
        assertEquals(null, userLogged);
    }

}
