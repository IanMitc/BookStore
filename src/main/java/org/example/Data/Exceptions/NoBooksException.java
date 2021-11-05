package org.example.Data.Exceptions;

public class NoBooksException extends Exception {

    public NoBooksException() {
    }

    public NoBooksException(String errorMessage) {
        super(errorMessage);
    }

}