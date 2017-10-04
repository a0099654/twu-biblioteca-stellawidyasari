package com.twu.biblioteca;

import org.junit.Test;
import sun.plugin2.message.Message;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private BibliotecaApp _bibliotecaApp = new BibliotecaApp();

    @Test
    public void userSeeWelcomeMessage() {
        assertEquals(MessageHelper.Welcome, "Welcome!");

    }
}
