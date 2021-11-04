package org.example.Data;

public class DaoFactory {

    private static AuthorDao authorDao;
    private static BookDao bookDao;
    private static CategoryDao categoryDao;
    private static UserDao userDao;

    private DaoFactory() {
    }

    public static AuthorDao getAuthorDao() {
        if (authorDao == null) {

        }
        return authorDao;
    }

    public static BookDao getBookDao() {
        if (bookDao == null) {

        }
        return bookDao;
    }

    public static CategoryDao getCategoryDao() {
        if (categoryDao == null) {

        }
        return categoryDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {

        }
        return userDao;
    }

}
