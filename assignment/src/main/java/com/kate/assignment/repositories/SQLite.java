package com.kate.assignment.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLite {

    // Path to the database file
    private static final String DB_URL = "jdbc:sqlite:src/main/resources/data.sql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Connect to the SQLite database
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");

            // // Step 2: Create a new table
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Breads");
            while (rs.next()) {
                System.out.println(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
