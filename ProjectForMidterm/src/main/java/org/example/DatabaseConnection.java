package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    // 🔹 Одно соединение для всего приложения
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected successfully!");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error connecting to the database: " + e.getMessage());
        }
        return connection;
    }
}
