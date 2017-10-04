package com.twu.biblioteca;

public class Book extends Item {
    private String _title;
    private String _author;
    private int _yearPublished;

    public Book(String title, String author, int yearPublished){
        _title = title;
        _author = author;
        _yearPublished = yearPublished;
    }

    public String getTitle(){
        return _title;
    }

    public String getAuthor(){
        return _author;
    }

    public int getYear(){
        return _yearPublished;
    }

    public String getInfo(){
        String whitespaceForTitle = String.format("%-20s", _title);
        String whitespaceForAuthor = String.format("%-20s", _author);

        return String.format("%s | %s | %s\n",
                whitespaceForTitle,
                whitespaceForAuthor,
                _yearPublished);
    }
}
