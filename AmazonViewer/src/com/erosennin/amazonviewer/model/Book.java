package com.erosennin.amazonviewer.model;

import com.erosennin.amazonviewer.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends Publication implements Visualizable {

    private int id;
    private String isbn;
    private ArrayList<Page> pages;
    private Date startDate;

    public Book(String title, String editorial, String[] authors, Date publicationDate, String isbn,
                boolean readed, ArrayList<Page> pages) {
        super(title, editorial, authors, publicationDate);
        super.setReaded(readed);
        this.isbn = isbn;
        this.pages = pages;
    }

    public static List<Book> makeBooksList() {
        List<Book> books = new ArrayList<>();
        String[] authors = new String[3];
        for (int i = 1; i < authors.length; i++) {
            authors[i] = "Author " + i;
        }
        for (int i = 1; i < 6; i++) {
            books.add(new Book("Book " + i, "Editorial " + i, authors, new Date(), "ISBN " + i,
                    false, Page.makePagesForBook()));
        }
        return books;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLastPageReaded() {
        int lastPageReaded = 0;
        for (int i = 0; i < pages.size(); i++) {
            if (pages.get(i).isReaded().equals("No")) {
                lastPageReaded = pages.get(i).getNumber() - 1;
                if (i != 0) {
                    lastPageReaded--;
                }
                break;
            } else if (i == pages.size() - 1) {
                lastPageReaded = pages.size() - 1;
            }
        }
        return lastPageReaded;
    }

    public void view() {
        startToSee(new Date());
        int lastPageReaded = getLastPageReaded();
        System.out.println(lastPageReaded);
        do {
            System.out.println("\n :: " + getTitle() + " :: ");
            System.out.println("\n...Page " + pages.get(lastPageReaded).getNumber() + "...");
            System.out.println(".........");
            System.out.println(pages.get(lastPageReaded).getContent());
            System.out.println(".........\n");
            pages.get(lastPageReaded).setReaded(true);
            if (lastPageReaded != 0) {
                System.out.println("1. Previous Page");
            }
            System.out.println("2. Next Page");
            System.out.println("0. Close Book");
            String option = Utils.validateUserResponseMenu(2);
            switch (option) {
                case "2":
                    lastPageReaded++;
                    break;
                case "1":
                    if (lastPageReaded != 0) {
                        lastPageReaded--;
                    } else {
                        System.out.println("\nThat option doesn't exist, please choose another.\n");
                    }
                    break;
                case "0":
                    lastPageReaded = pages.size();
                    break;
            }
        } while (lastPageReaded < pages.size());
        stopToSee(new Date());
        System.out.println("\n::YOU JUST SAW::\n" + toString());
        setReaded(true);
    }

    @Override
    public String toString() {
        StringBuilder printerAuthors = new StringBuilder();
        String[] authors = getAuthors();
        for (String author : authors) {
            printerAuthors.append(author).append(", ");
        }
        printerAuthors.delete(printerAuthors.length() - 2, printerAuthors.length() - 1);
        return "\n::BOOK::" +
                "\nTitle: " + getTitle() +
                "\nPublisher: " + getEditorial() +
                "\nAuthors: " + printerAuthors +
                "\nPublication Date: " + new SimpleDateFormat("dd/MM/yyyy").format(getPublicationDate()) +
                "\nISBN: " + getIsbn() +
                "\nReaded: " + isReaded() +
                "\nPages: " + pages.size();
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

    @Override
    public void setReaded(boolean readed) {
        super.setReaded(readed);
        for (Page page : pages) {
            if (page.isReaded().equals("No")) {
                super.setReaded(false);
                break;
            }
        }
    }


    public static class Page {

        private int id;
        private int number;
        private String content;
        private boolean readed;

        public Page(int number, String content) {
            this.number = number;
            this.content = content;
        }

        public static ArrayList<Page> makePagesForBook() {
            ArrayList<Page> pages = new ArrayList<>();
            for (int i = 1; i < 7; i++) {
                pages.add(new Page(i, "Content...\nContent...\nContent...\nContent..."));
            }
            return pages;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public String getContent() {
            return content;
        }

        public String isReaded() {
            return (readed) ? "Yes" : "No";
        }

        public void setReaded(boolean readed) {
            this.readed = readed;
        }
    }
}