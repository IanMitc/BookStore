package org.example.Objects;

//Class for book objects created from the database
public class Book {

    String ISBN;
    String Title;
    double price;

    public Book() {
    }

    public Book(String ISBN, String title, double price) {
        this.ISBN = ISBN;
        Title = title;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
