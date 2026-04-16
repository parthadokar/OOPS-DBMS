package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseManager {
    // handles Postgres connection
    private static final Dotenv dotenv = Dotenv.load();
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = dotenv.get("DB_USERNAME");
    private static final String password = dotenv.get("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Call this once when the program starts
    public static void initializeDatabase() {
        String sql = """
                CREATE TABLE IF NOT EXISTS employees (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                clearance_level VARCHAR(2) CHECK (clearance_level IN ('L1', 'L2', 'L3', 'L4'))
                );
                """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database Ready");
        } catch (SQLException e) {
            System.out.println("DB init failed: " + e.getMessage());
        }
    }
}
