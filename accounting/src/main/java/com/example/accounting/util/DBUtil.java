package com.example.accounting.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "accounting_user";
    private static final String PASS = "password";

    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
