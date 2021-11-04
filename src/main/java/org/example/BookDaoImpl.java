package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookDaoImpl implements BookDao{

    Connection connection;

    public BookDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Book> getBooks() throws NoBooksException {
        String sql = "select * from books";
        List<Book> list = new LinkedList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet books = preparedStatement.executeQuery();
            while (books.next()) {
                String isbn = books.getString("isbn");
                String title = books.getString("title");
                double price = books.getDouble("price");
                list.add(new Book(isbn, title, price));
            }
        } catch (SQLException e) {
            throw new NoBooksException();
        }
        return list;
    }

    @Override
    public Book getBook(String isbn) {
        return null;
    }
}
