package com.erosennin.amazonviewer.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Magazine extends Publication implements Visualizable{

    private int id;
    private String releaseFrequency;
    private Date lastRelease;
    private Date startDate;

    public Magazine(String title, String editorial, String[] authors, Date publicationDate, String releaseFrequency,
                    Date lastRelease, boolean readed) {
        super(title, editorial, authors, publicationDate);
        super.setReaded(readed);
        this.releaseFrequency = releaseFrequency;
        this.lastRelease = lastRelease;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getReleaseFrequency() {
        return releaseFrequency;
    }

    public Date getLastRelease() {
        return lastRelease;
    }

    public static List<Magazine> makeMagazinesList() {
        List<Magazine> magazines = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            magazines.add(new Magazine("Magazine " + i, "Editorial " + i, new String[]{"Author " + i}, new Date(),
                    "Release Frecuency " + i, new Date(), false));
        }
        return magazines;
    }

    @Override
    public String toString() {
        StringBuilder printerAuthors = new StringBuilder();
        String[] authors = getAuthors();
        for (String author : authors) {
            printerAuthors.append(author).append(", ");
        }
        printerAuthors.delete(printerAuthors.length()-2,printerAuthors.length()-1);
        return  "\n::MAGAZINE::" +
                "\nTitle: " + getTitle() +
                "\nPublisher: " + getEditorial() +
                "\nAuthors: " + printerAuthors +
                "\nFirst Publication Date: " + new SimpleDateFormat("dd/MM/yyyy").format(getPublicationDate()) +
                "\nLast Publication Date: " + new SimpleDateFormat("dd/MM/yyyy").format(getLastRelease()) +
                "\nRelease Frequency: " + getReleaseFrequency();
    }

    @Override
    public void startToSee(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public void stopToSee(Date endDate) {
        if (startDate.getTime() < endDate.getTime()) {
            setTimeReaded((int) (endDate.getTime() - startDate.getTime()));
        } else {
            setTimeReaded(0);
        }
    }
}
