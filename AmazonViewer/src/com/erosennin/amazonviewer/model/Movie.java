package com.erosennin.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie extends Film implements Visualizable{

    private int id;


    public Movie(int duration, String title, String genre, String creator, short year) {
        super(duration, title, genre, creator);
        this.setYear(year);
    }

    public int getId() {
        return id;
    }

    public static List<Movie> makeMoviesList() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            movies.add(new Movie(120+i, "Movie "+i,"Genre "+i,"Director "+i, (short) (2014+i)));
        }
        return movies;
    }

    @Override
    public String toString() {
        return "\nTitle: " + this.getTitle() +
                "\nGenre: " + this.getGenre() +
                "\nYear: " + this.getYear() +
                "\nCreator: " + this.getCreator() +
                "\nDuration: " + this.getDuration() +
                "\nSeconds viewed: " + this.getTimeViewed();
    }

    @Override
    public void startToSee(Date startDate) {
        setStartDate(startDate);
    }

    @Override
    public void stopToSee(Date endDate) {
        if (getStartDate().getTime() < endDate.getTime()) {
            setTimeViewed((int) (endDate.getTime() - getStartDate().getTime()));
        } else {
            setTimeViewed(0);
        }
    }

}
