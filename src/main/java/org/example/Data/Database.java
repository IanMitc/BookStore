package org.example.Data;

import org.example.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    public static void initialize() {
        initializeTables();
        //populateDefaultData();
    }

    private static void populateDefaultData() {
        Connection connection = ConnectionFactory.getConnection();
        List<String> sqlInserts = new ArrayList<>();
        Collections.addAll(sqlInserts,
                "INSERT INTO books values (9788433928016, 'Silk', 14.99)",
                "INSERT INTO author values (1, 'Alessandro', 'Baricco')",
                "INSERT INTO book2author values (9788433928016, 1)",

                "INSERT INTO books values (9780590198592, 'Lioness Rampant', 9.95)",
                "INSERT INTO author values (2, 'Tamora', 'Pierce')",
                "INSERT INTO book2author values (9780590198592, 2)",

                "INSERT INTO books values (9780345805249, 'This Is How You Lose Her', 19.37)",
                "INSERT INTO author values (3, 'Junot', 'Diaz')",
                "INSERT INTO book2author values (9780345805249, 3)",

                "INSERT INTO books values (9780425289006, 'George Washington's Secret Six: The Spy Ring That Saved the American Revolution', 21.50)",
                "INSERT INTO author values (4, 'Brian', 'Kilmeade')",
                "INSERT INTO author values (5, 'Don', 'Yaeger')",
                "INSERT INTO book2author values (9780425289006, 4)",
                "INSERT INTO book2author values (9780425289006, 5)",

                "INSERT INTO books values (9781400031511, 'One Step Behind', 9.99)",
                "INSERT INTO author values (6, 'Henning', 'Mankell')",
                "INSERT INTO author values (7, 'Ebba', 'Segerberg')",
                "INSERT INTO book2author values (9781400031511, 6)",
                "INSERT INTO book2author values (9781400031511, 7)",

                "INSERT INTO books values (9780751557053, 'Galveston', 10.99)",
                "INSERT INTO author values (8, 'Nic', 'Pizzolatto')",
                "INSERT INTO book2author values (9780751557053, 8)",

                "INSERT INTO books values (9780316109697, 'Julie and Julia: 365 Days, 524 Recipes, 1 Tiny Apartment Kitchen', 19.99)",
                "INSERT INTO author values (9, 'Julie', 'Powell')",
                "INSERT INTO book2author values (9780316109697, 9)",

                "INSERT INTO books values (9780007255306, 'Wicked Lovely', 19.99)",
                "INSERT INTO author values (10, 'Melissa', 'Marr')",
                "INSERT INTO book2author values (9780007255306, 10)",

                "INSERT INTO books values (9780671028374, 'Fatal Voyage', 19.99)",
                "INSERT INTO author values (11, 'Kathy', 'Reichs')",
                "INSERT INTO book2author values (9780671028374, 11)",

                "INSERT INTO books values (9781497455047, 'Mud Vein', 7.99)",
                "INSERT INTO author values (12, 'Tarryn', 'Fisher')",
                "INSERT INTO book2author values (9781497455047, 12)",

                "INSERT INTO books values (9780316349932, 'Career of Evil', 99.99)",
                "INSERT INTO author values (13, 'Robert', 'Galbraith')",
                "INSERT INTO author values (14, 'J.K.', 'Rowling')",
                "INSERT INTO book2author values (9780316349932, 13)",
                "INSERT INTO book2author values (9780316349932, 14)",

                "INSERT INTO books values (9781417796441, 'The 5th Horseman', 99.99)",
                "INSERT INTO author values (15, 'James', 'Patterson')",
                "INSERT INTO author values (16, 'Maxine', 'Paetro')",
                "INSERT INTO book2author values (9781417796441, 15)",
                "INSERT INTO book2author values (9781417796441, 16)",

                "INSERT INTO books values (9780345505729, 'Victims', 10.99)",
                "INSERT INTO author values (17, 'Jonathan', 'Kellerman')",
                "INSERT INTO book2author values (9780345505729, 17)",

                "");
        try {
            Statement statement = connection.createStatement();
            for (String sqlInsert : sqlInserts) {
                statement.addBatch(sqlInsert);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            //System.out.println(e.getSQLState());
        }
    }

    private static void initializeTables() {
        Connection connection = ConnectionFactory.getConnection();

        String getTablesSql = "show tables";
        String createAuthorTableSql = "CREATE TABLE `author` (" +
                "  `Id` int NOT NULL AUTO_INCREMENT," +
                "  `FirstName` varchar(50) DEFAULT NULL," +
                "  `LastName` varchar(50) DEFAULT NULL," +
                "  PRIMARY KEY (`Id`)" +
                ")";
        String createBooksTableSql = "CREATE TABLE `books` (" +
                "  `Isbn` int(13) NOT NULL," +
                "  `Title` varchar(255) DEFAULT NULL," +
                "  `Price` double(10,2) DEFAULT NULL," +
                "  PRIMARY KEY (`Isbn`)" +
                ")";
        String createCategoryTableSql = "CREATE TABLE `category` (" +
                "  `Id` int NOT NULL AUTO_INCREMENT," +
                "  `Category` varchar(50) DEFAULT NULL," +
                "  PRIMARY KEY (`Id`)" +
                ")";
        String createBook2CatagorySql = "CREATE TABLE `book2category` (" +
                "  `Book_id` varchar(50) NOT NULL," +
                "  `Category_id` int NOT NULL," +
                "  KEY `Book_id` (`Book_id`)," +
                "  KEY `Category_id` (`Category_id`)," +
                "  CONSTRAINT `book2category_ibfk_1` FOREIGN KEY (`Book_id`) REFERENCES `books` (`Isbn`)," +
                "  CONSTRAINT `book2category_ibfk_2` FOREIGN KEY (`Category_id`) REFERENCES `category` (`Id`)" +
                ")";
        String createBook2AuthorTable = "CREATE TABLE `book2author` (" +
                "  `Book_id` varchar(50) NOT NULL," +
                "  `Author_id` int NOT NULL," +
                "  KEY `Book_id` (`Book_id`)," +
                "  KEY `Author_id` (`Author_id`)," +
                "  CONSTRAINT `book2author_ibfk_1` FOREIGN KEY (`Book_id`) REFERENCES `books` (`Isbn`)," +
                "  CONSTRAINT `book2author_ibfk_2` FOREIGN KEY (`Author_id`) REFERENCES `author` (`Id`)" +
                ")";
        String createUserTableSql = "CREATE TABLE `user` (" +
                "  `Id` int NOT NULL AUTO_INCREMENT," +
                "  `Username` varchar(50) DEFAULT NULL," +
                "  `Password` varchar(50) DEFAULT NULL," +
                "  PRIMARY KEY (`Id`)" +
                ")";

        try (Statement statement = connection.createStatement()) {
            List<String> tables = new ArrayList<>();

            ResultSet rs = statement.executeQuery(getTablesSql);
            while (rs.next()) {
                tables.add(rs.getString(1));
            }

            if (!tables.contains("user")) {
                statement.addBatch(createUserTableSql);
            }

            if (!tables.contains("author")) {
                statement.addBatch(createAuthorTableSql);
            }

            if (!tables.contains("books")) {
                statement.addBatch(createBooksTableSql);
            }

            if (!tables.contains("category")) {
                statement.addBatch(createCategoryTableSql);
            }
            if (!tables.contains("book2author")) {
                statement.addBatch(createBook2AuthorTable);
            }
            if (!tables.contains("book2category")) {
                statement.addBatch(createBook2CatagorySql);
            }

            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}