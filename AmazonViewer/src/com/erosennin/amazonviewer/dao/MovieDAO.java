package com.erosennin.amazonviewer.dao;

import com.erosennin.amazonviewer.db.IDBConnection;
import com.erosennin.amazonviewer.model.Movie;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.erosennin.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection {

    default ArrayList<Movie> read() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectDB()) {
            String query = String.format("SELECT * FROM %s", TMOVIE);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt(TMOVIE_ID),
                        resultSet.getInt(TMOVIE_DURATION),
                        resultSet.getString(TMOVIE_TITLE),
                        resultSet.getString(TMOVIE_GENRE),
                        resultSet.getString(TMOVIE_CREATOR),
                        resultSet.getShort(TMOVIE_YEAR));
                String movieViewed = getMovieViewed(connection, resultSet.getInt(TMOVIE_ID));
                movie.setViewed(!movieViewed.equals(""));
                movie.setDateString(movieViewed);
                System.out.println(movie);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return movies;
    }

    default void setMovieViewed(Movie movie) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = simpleDateFormat.format(movie.getStartDate());
        String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (" +
                        "(SELECT %s FROM %s WHERE %s = '%s'), %s," +
                        "(SELECT %s FROM %s), '%s')",
                TVIEWED, TVIEWED_ID_MATERIAL, TVIEWED_ID_ELEMENT, TVIEWED_ID_USER, TVIEWED_DATE,
                TMATERIAL_ID, TMATERIAL, TMATERIAL_NAME, TMOVIE, movie.getId(),
                TUSER_ID, TUSER, dateFormatted);
        try (Connection connection = connectDB()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private String getMovieViewed(Connection connection, int idMovie) {
        String query = String.format("SELECT * FROM %s WHERE %s = " +
                        "( SELECT %s FROM %s WHERE %s = '%s' ) " +
                        "AND %s = ? AND %s = " +
                        "( SELECT %s FROM %s )",
                TVIEWED, TVIEWED_ID_MATERIAL,
                TMATERIAL_ID, TMATERIAL, TMATERIAL_NAME, TMOVIE,
                TVIEWED_ID_ELEMENT, TVIEWED_ID_USER,
                TUSER_ID, TUSER);
        String date = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idMovie);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                date = resultSet.getString(TVIEWED_DATE);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return date;
    }
}
