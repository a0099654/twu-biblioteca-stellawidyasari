package com.twu.biblioteca;

public final class MessageHelper {

    public static String Welcome = "Welcome!";
    public static String LibraryNumber = "Library number: ";
    public static String Password = "Password: ";

    public static String SearchBookInLibrary = "Type book title: ";
    public static String OptionIsInvalid = "Select a valid option!";
    public static String MenuOptions = "Choose an option:\n" +
            "1 - List Books\n" +
            "2 - Checkout Book\n" +
            "3 - Return Book\n" +
            "4 - Login\n" +
            "5 - User information\n" +
            "0 - Quit\n" +
            "";

    public static final String LoginUserSuccess ="Login successful. Welcome %s!";
    public static final String LoginUserError = "Incorrect library number or password.";
    public static final String LoginIsRequired = "You must login to proceed";

    public static String CheckoutBookSuccess = "Thank you! Enjoy the book";
    public static String CheckoutBookError = "That book is not available";
    public static String ReturnBookSuccess = "Thank you for returning the book";
    public static String ReturnBookError = "That is not a valid book to return";


    public static String Quit = "Quit";
}
