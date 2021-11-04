package org.example;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public BookNotFoundException() {

    }
}
