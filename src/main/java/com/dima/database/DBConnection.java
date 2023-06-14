package com.dima.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static boolean connect() {
        System.out.println(DBConstants.DB_CONNECTION_URL);
        try {
            conn = DriverManager.getConnection(DBConstants.DB_CONNECTION_URL);
            return true;
        } catch (SQLException e) {
            System.out.println(DBConstants.DB_CONNECTION_ERROR + " " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean close() {
        try {
            if (conn != null) {
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(DBConstants.DB_CLOSE_ERROR + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static Connection getConnection() {
        return conn;
    }
}
