package org.example.Data;

import org.example.Data.Exceptions.BookNotFoundException;
import org.example.Data.Exceptions.NoBooksException;
import org.example.Objects.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    Connection connection;

    public BookDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Book> getBooks() throws NoBooksException {
        String sql = "select * from books";
        List<Book> list = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet books = preparedStatement.executeQuery();
            while (books.next()) {
                String isbn = books.getString("Isbn");
                String title = books.getString("Title");
                double price = books.getDouble("Price");
                list.add(new Book(isbn, title, price));
            }
        } catch (SQLException e) {
            throw new NoBooksException();
        }
        return list;
    }

    @Override
    public Book getBook(String isbn) throws BookNotFoundException {
        String sql = "select * from books where Isbn = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, isbn);
            ResultSet books = preparedStatement.executeQuery();
            books.next();
            String isbn1 = books.getString("Isbn");
            String title = books.getString("Title");
            double price = books.getDouble("Price");
            return new Book(isbn1, title, price);
        } catch (SQLException e) {
            throw new BookNotFoundException();
        }
    }

    @Override
    public List<Book> getBooksByCategory(int category) throws NoBooksException {
        String sql = "SELECT * FROM book2category WHERE Category_id = ?";
        List<Integer> idList = new LinkedList<>();
        List<Book> list = new LinkedList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category);
            ResultSet bookIds = preparedStatement.executeQuery();
            while (bookIds.next()) {
                list.add(getBook(bookIds.getString("Book_id")));
            }
        } catch (SQLException e) {
            throw new NoBooksException();
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
