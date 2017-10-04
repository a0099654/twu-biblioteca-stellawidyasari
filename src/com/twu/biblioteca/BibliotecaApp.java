package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcomeMessage();
        bibliotecaApp.init();
    }

    public static void welcomeMessage(){
        System.out.println(MessageHelper.Welcome);
    }

    public void init(){
        Menu menu = new Menu();
        menu.init();
    }
}
