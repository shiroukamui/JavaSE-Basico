package com.erosennin.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Serie extends Film implements Visualizable{

    private int id;
    private int seasonQuantity;
    private List<Chapter> chapters;

    public Serie(int duration, String title, String genre, String creator, int seasonQuantity, List<Chapter> chapters) {
        super(duration, title, genre, creator);
        this.seasonQuantity = seasonQuantity;
        this.chapters = chapters;
    }

    public int getId() {
        return id;
    }

    public int getSeasonQuantity() {
        return seasonQuantity;
    }

    public void setSeasonQuantity(int seasonQuantity) {
        this.seasonQuantity = seasonQuantity;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public static List<Serie> makeSeriesList() {
        List<Serie> series = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            series.add(new Serie(1200+i, "Serie "+i,"Genre "+i,"Director "+i,
                    1+i, Chapter.makeChaptersList()));
        }
        return series;
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

    @Override
    public void view() {
        setViewed(true);
        List<Chapter> chapters = getChapters();
        for (Chapter chapter : chapters) {
            if (chapter.getViewed().equals("No")) {
                setViewed(false);
                break;
            }
        }
    }
}
