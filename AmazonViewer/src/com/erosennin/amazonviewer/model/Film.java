package com.erosennin.amazonviewer.model;

import java.util.Date;

public class Film {

    private int duration;
    private int timeViewed;
    private String title;
    private String genre;
    private String creator;
    private short year;
    private boolean viewed;
    private Date startDate;

    public Film(int duration, String title, String genre, String creator) {
        this.duration = duration;
        this.title = title;
        this.genre = genre;
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public int getTimeViewed() {
        return timeViewed / 1000;
    }

    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getCreator() {
        return creator;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String isViewed() {
        return (viewed) ? "Yes" : "No";
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
