package org.example.Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ShoppingCart {
    private static List<Book> books;
    private static ShoppingCart shoppingCart = null;

    private ShoppingCart() {
        books = new ArrayList<>();
    }

    public static ShoppingCart getShoppingCart() {
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }

    public List<Book> getBooks() {
        return books;
    }

    public double getTotal() {
        double total = 0;

        for (Book b : books) {
            total += b.getPrice();
        }

        return total;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeAll() {
        books = new ArrayList<>();
    }
}
