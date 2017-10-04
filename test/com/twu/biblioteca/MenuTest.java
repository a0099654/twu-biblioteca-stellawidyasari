package com.twu.biblioteca;

import com.twu.biblioteca.mock.MockItems;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private Menu _menu = new Menu();

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
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void menuShouldBePrinted() throws FileNotFoundException {
        _menu.printMenu();

        String[] menu = MessageHelper.MenuOptions.split("\n");
        String[] outputSpy = outContent.toString().split("\n");

        assertEquals(menu.length, outputSpy.length);
    }

    @Test
    public void messageErrorShouldBeDisplayedForInvalidOptionOnMenu(){
        _menu.menuOptions(10);
        assertEquals(MessageHelper.OptionIsInvalid + _breakline, outContent.toString());
    }

    @Test
    public void bookListDetailsShouldBePrintedInMenu() throws FileNotFoundException {
        _menu.menuOptions(1);

        String[] bookDetails = outContent.toString().split("\n");
        System.out.println(outContent.toString());
        System.out.println(MockItems.getBookList().size());
        assertEquals(bookDetails.length, MockItems.getBookList().size());
    }


}
