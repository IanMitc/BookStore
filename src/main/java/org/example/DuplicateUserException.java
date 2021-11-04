package org.example;

public class DuplicateUserException extends Exception{

    public DuplicateUserException(String errorMessage) {
        super(errorMessage);
    }

    public DuplicateUserException() {

    }
}
