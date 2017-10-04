package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.showWelcomeMessage();
        bibliotecaApp.init();
    }

    public static void showWelcomeMessage(){
        System.out.println(MessageHelper.Welcome);
    }

    public void init(){
        Menu menu = new Menu();
        menu.init();
    }
}
