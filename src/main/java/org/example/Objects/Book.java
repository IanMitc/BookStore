package org.example.Objects;

import org.example.Data.AuthorDao;
import org.example.Data.DaoFactory;

import java.util.List;

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

    @Override
    public String toString() {
        AuthorDao authorDao = DaoFactory.getAuthorDao();
        List<Author> authors = authorDao.getAuthor(ISBN);
        StringBuilder authorCombined = new StringBuilder();
        int i = 1;
        for (Author a : authors){
            if (i++ > 1)
                authorCombined.append(" & ");
            authorCombined.append(a.getFirstName()).append(" ").append(a.getLastName());
        }

        return Title + " by " + authorCombined;
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
