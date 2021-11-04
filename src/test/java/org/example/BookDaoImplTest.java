package org.example;

import org.example.Data.BookDao;
import org.example.Data.DaoFactory;
import org.example.Data.Exceptions.BookNotFoundException;
import static org.junit.Assert.assertEquals;
import org.example.Objects.Book;
import org.junit.Test;

public class BookDaoImplTest {

    @Test
    public void testBooks() {
        //Arrange
        BookDao bookDao = DaoFactory.getBookDao();

        String isbn = "9780007255306";

        Book realBook;
        try {
             realBook = bookDao.getBook(isbn);
            Book wantedBook = new Book(isbn, "Wicked Lovely", 19.99);
            assertEquals(wantedBook.getISBN(), realBook.getISBN());
            assertEquals(wantedBook.getPrice(), realBook.getPrice(), 0);
            assertEquals(wantedBook.getTitle(), realBook.getTitle());
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
