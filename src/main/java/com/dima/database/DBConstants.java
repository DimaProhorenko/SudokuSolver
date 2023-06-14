package com.dima.database;

public abstract class DBConstants {
    public static final String DB_NAME = "database.db";
    public static final String DB_DRIVER = "jdbc:sqlite:";
    public static final String DB_BASE_URL = "src\\main\\resources\\database\\";
    public static final String DB_CONNECTION_URL = DB_DRIVER + DB_BASE_URL + DB_NAME;


//    Error messages
    public static final String DB_CONNECTION_ERROR = "Couldn't connect to " + DB_BASE_URL + DB_NAME;
    public static final String DB_CLOSE_ERROR = "Couldn't close database " + DB_BASE_URL + DB_NAME;
}
