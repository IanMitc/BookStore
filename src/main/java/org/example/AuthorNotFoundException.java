package org.example;

public class AuthorNotFoundException extends Exception{

    public AuthorNotFoundException() {
    }

    public AuthorNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
