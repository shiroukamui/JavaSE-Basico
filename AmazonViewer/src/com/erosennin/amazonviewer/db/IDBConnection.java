package com.erosennin.amazonviewer.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface IDBConnection {

    default Connection connectDB() {
        Properties properties = getDBCredentials();
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"), properties.getProperty("db.pass"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Properties getDBCredentials() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
