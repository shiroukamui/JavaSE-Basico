package com.erosennin.amazonviewer.challenges;

import java.sql.*;

public class GuitarJDBC {

    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/GUITARS_SAMPLE";
    static final String user = "DB_ADMIN";
    static final String pass = "Mariadb";
    static final String query = "select Id, Name from guitar where IsPremium = (select IsPremium from client where Id=?)";

    public static void executeQuery(String IdUser) {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, IdUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                System.out.println("ID: " + id + " NAME: " + name);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
