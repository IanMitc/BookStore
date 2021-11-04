package org.example.Objects;

import java.util.List;

import java.util.List;

//Class for book objects created from the database
public class Book {

    private String ISBN;
    private String title;
    private double price;
    private List<Author> authors;
    private List<Category> categories;

    public Book() {
    }

    public Book(String ISBN, String title, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
    }



    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
