package com.erosennin.amazonviewer.model;

import java.util.Date;

public class Publication {

    private String title;
    private String editorial;
    private String[] authors;
    private Date publicationDate;
    private int timeReaded;
    private boolean readed;

    Publication(String title, String editorial, String[] authors, Date publicationDate) {
        this.title = title;
        this.editorial = editorial;
        this.authors = authors;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public String isReaded() {
        return (readed) ? "Yes" : "No";
    }

    public String getEditorial() {
        return editorial;
    }

    public String[] getAuthors() {
        return authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getTimeReaded() {
        return timeReaded / 1000;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }
}
