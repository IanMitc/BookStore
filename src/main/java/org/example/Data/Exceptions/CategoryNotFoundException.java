package org.example.Data.Exceptions;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException() {

    }

    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
