package org.example.Data;

import org.example.AuthorDaoImpl;
import org.example.BookDaoImpl;
import org.example.CategoryDaoImpl;
import org.example.UserDaoImpl;

public class DaoFactory {

    private static AuthorDao authorDao;
    private static BookDao bookDao;
    private static CategoryDao categoryDao;
    private static UserDao userDao;

    private DaoFactory() {}

    public static AuthorDao getAuthorDao() {
        if(authorDao == null) {
            authorDao = (AuthorDao) new AuthorDaoImpl();
        }
        return authorDao;
    }

    public static BookDao getBookDao() {
        if(bookDao == null) {
            bookDao = new BookDaoImpl();
        }
        return bookDao;
    }

    public static CategoryDao getCategoryDao() {
        if(categoryDao == null) {
            categoryDao = new CategoryDaoImpl();
        }
        return categoryDao;
    }

    public static UserDao getUserDao() {
        if(userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

}
