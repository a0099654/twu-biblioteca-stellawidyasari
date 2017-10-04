package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private BibliotecaApp _bibliotecaApp = new BibliotecaApp();

    private String _breakline = "\n";

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


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
    public void userShouldSeeAWelcomeMessage() {
        _bibliotecaApp.showWelcomeMessage();

        assertEquals(MessageHelper.Welcome + _breakline, outContent.toString());
    }
}
