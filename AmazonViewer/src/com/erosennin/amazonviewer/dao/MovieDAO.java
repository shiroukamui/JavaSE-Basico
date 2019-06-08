package com.erosennin.amazonviewer.dao;

import com.erosennin.amazonviewer.model.Movie;

import java.util.ArrayList;

public interface MovieDAO {

    default Movie setMovieViewed(Movie movie) {
        return movie;
    }

    default ArrayList<Movie> read() {
        return new ArrayList<>();
    }

    private boolean getMovieViewed() {
        return false;
    }
}
