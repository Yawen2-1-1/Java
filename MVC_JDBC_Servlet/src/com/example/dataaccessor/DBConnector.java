package com.example.dataaccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static String url = "jdbc:oracle:thin:@10.230.214.63:2191/C146DEV";
    static String user = "KH_EDU";
    static String password = "KHEDU";

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
