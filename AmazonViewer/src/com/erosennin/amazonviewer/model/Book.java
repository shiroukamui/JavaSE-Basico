package com.erosennin.amazonviewer.model;

import com.erosennin.amazonviewer.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Book extends Publication implements Visualizable {

    private int id;
    private String isbn;
    private int pages;
    private Date startDate;

    public Book(String title, String editorial, String[] authors, Date publicationDate, String isbn, boolean readed, int pages) {
        super(title, editorial, authors, publicationDate);
        super.setReaded(readed);
        this.isbn = isbn;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    public static List<Book> makeBooksList() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            books.add(new Book("Book " + i, "Editorial " + i, new String[]{"Author " + i}, new Date(),
                    "ISBN " + i, false, 200 + i));
        }
        return books;
    }

    public void view() {
        setReaded(true);
        startToSee(new Date());
        for (int i = 0; i < 100; i++) {
            System.out.println("...You are reading the " + getTitle() + "...");
        }
        Utils.timeDelay(2);
        stopToSee(new Date());
        System.out.println("\n::YOU JUST SAW::" + toString());
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
                "\nPages: " + getPages();
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