package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Biblioteca _biblioteca;

    private User _currentUser;

    public Menu() {
        _biblioteca = new Biblioteca(new ArrayList<Book>() {{
            add(new Book("Awesome book 1", "Cool Person", 2017));
            add(new Book("Awesome book 2", "Cool Person 2", 2016));
            add(new Book("Awesome book 3", "Cool Person 3", 2015));
        }});
    }

    public String readInputInformation(String message){
        Scanner text = new Scanner(System.in);
        System.out.println(message);
        String itemInformation = text.nextLine();
        return itemInformation;
    }

    public void menuOptions(int option) {
        String message = "";
        switch (option) {
            case 1:
                message += _biblioteca.getBookListDetails();
                break;
            case 2:

                if (!hasUserLogged()) {
                    userLogin(MessageHelper.LoginIsRequired);
                } else {
                    boolean checkoutBookWithSuccess = _biblioteca.checkoutBook(readInputInformation(MessageHelper.SearchBookInLibrary), _currentUser.getLibraryNo());
                    message += (checkoutBookWithSuccess == true) ?
                            MessageHelper.CheckoutBookSuccess :
                            MessageHelper.CheckoutBookError;
                }

                break;
            case 3:

                if (!hasUserLogged()) {
                    userLogin(MessageHelper.LoginIsRequired);
                } else {
                    boolean bookWasReturnedWithSuccess = _biblioteca.returnBook(readInputInformation(MessageHelper.SearchBookInLibrary));
                    message += (bookWasReturnedWithSuccess) ?
                            MessageHelper.ReturnBookSuccess :
                            MessageHelper.ReturnBookError;
                }
                break;
            case 4:
                userLogin(MessageHelper.LoginIsRequired);
                break;

            case 5:

                if (!hasUserLogged()) {
                    userLogin(MessageHelper.LoginIsRequired);
                } else {
                    message += _biblioteca.getUserLoggedDetails();
                }
                break;

            case 0:
                message += MessageHelper.Quit;
                break;
            default:
                message += MessageHelper.OptionIsInvalid;
        }
        System.out.println(message);

        if (option == 0) {
            System.exit(1);
        }
    }

    public void printMenu(){
        System.out.println(MessageHelper.MenuOptions);
    }

    public void init(){
        Scanner in = new Scanner(System.in);
        int option = 0;
        printMenu();

        while (true){
            try {
                option = in.nextInt();
                menuOptions(option);
                printMenu();
            }catch (Exception e){
                System.out.println(MessageHelper.OptionIsInvalid);
                init();
            }

        }
    }

    public boolean hasUserLogged () {
        return _currentUser != null && _currentUser.isLogged == true;
    }

    public void userLogin(String message) {
        System.out.println(message);
        String libraryNumber = readInputInformation(MessageHelper.LibraryNumber);
        String password = readInputInformation(MessageHelper.Password);
        boolean userIsLogged = _biblioteca.login(libraryNumber, password);

        if (userIsLogged){
            _currentUser = _biblioteca.getUserLogged();
            message = String.format(MessageHelper.LoginUserSuccess, _currentUser.getName());
        }else{
            message = MessageHelper.LoginUserError;
        }

        System.out.println(message);
    }
}
