package org.example.Data.Exceptions;

public class BookNotFoundException extends Exception {

    public BookNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public BookNotFoundException() {

    }
}
