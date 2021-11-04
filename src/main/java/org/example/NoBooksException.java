package org.example;

public class NoBooksException extends Exception {

    public NoBooksException() {
    }

    public NoBooksException(String errorMessage) {
        super(errorMessage);
    }

}