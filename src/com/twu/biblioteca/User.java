package com.twu.biblioteca;

public class User {
    private String _name;
    private String _email;
    private String _phone;

    private String _libraryNo;
    private String _password;
    public boolean isLogged;

    public User(String name, String email, String phone, String libraryNo, String password){
        _name = name;
        _email = email;
        _phone = phone;
        _libraryNo = libraryNo;
        _password = password;
        isLogged = false;
    }

    public String getName(){
        return _name;
    }

    public String getEmail(){
        return _email;
    }

    public String getPhone(){
        return _phone;
    }

    public String getLibraryNo(){
        return _libraryNo;
    }

    public String getPassword(){
        return _password;
    }

    public boolean checkCredential(String libraryNo, String password){
        return _libraryNo.equals(libraryNo) && _password.equals(password);

    }

    public String getInfo(){

        return "User Information:\n\n"+
                "Name:         " + _name +  "\n" +
                "Email:        " + _email + "\n" +
                "Phone number: " + _phone + "\n";
    }
}
