package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaApp _bibliotecaApp = new BibliotecaApp();

    @Test
    public void userSeeWelcomeMessage() {
        assertEquals("Welcome",  _bibliotecaApp.welcomeMessage());

    }
}
