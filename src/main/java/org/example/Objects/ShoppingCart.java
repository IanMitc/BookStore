package org.example.Objects;

import java.util.List;

public class ShoppingCart {
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public double getTotal() {
        double total = 0;

        for (Book b : books){
            total += b.getPrice();
        }

        return total;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }
}
