package org.example.Data.Exceptions;

public class AuthorNotFoundException extends Exception {

    public AuthorNotFoundException() {
    }

    public AuthorNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
