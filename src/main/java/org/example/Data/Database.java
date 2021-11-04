package org.example.Data;

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
                "INSERT INTO users values (1, 'Administrator', 'admin', 'ADMIN', 'password', true)",
                "INSERT INTO users values (2, 'Employee', 'employee', 'EMPLOYEE', 'password', true)",
                "INSERT INTO users values (3, 'Mr. Customer', 'mrcx', 'CUSTOMER', 'password', true)",
                "INSERT INTO users values (4, 'Ms. Customer', 'mscx', 'CUSTOMER', 'password', true)",
                "INSERT INTO accounts values (1, 5000000, false, false, false, false)",
                "INSERT INTO accounts values (2, 500, false, false, false, false)",
                "INSERT INTO accounts values (3, 2000, false, false, false, false)",
                "INSERT INTO accounts values (4, 100, false, false, false, false)",
                "INSERT INTO accounts values (5, 200, false, false, false, false)",
                "INSERT INTO accounts values (6, 200, false, false, true, false)",
                "INSERT INTO user2account values (3, 3)",
                "INSERT INTO user2account values (3, 4)",
                "INSERT INTO user2account values (3, 5)",
                "INSERT INTO user2account values (3, 6)",
                "INSERT INTO user2account values (4, 2)",
                "INSERT INTO user2account values (4, 4)");
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
        String createBookTableSql = "CREATE TABLE `books` (" +
                "  `Isbn` varchar(50) NOT NULL," +
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
                statement.addBatch(createBookTableSql);
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