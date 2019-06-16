package com.erosennin.amazonviewer;

import com.erosennin.amazonviewer.model.*;
import com.erosennin.amazonviewer.utils.Utils;
import com.erosennin.reports.Report;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 * <h1>AmazonViewer</h1>
 * AmazonViewer es un programa que permite visualizar Movies, Series con sus respectivos Chapters, Books y Magazines.
 * Te permite generar reportes generales y con la fecha del día.
 * <br>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados o leídos con excepción de los Magazines,
 * estas solo pueden ser vistas a modo de exposición sin ser leídas.
 *
 * @author erosennin
 * @version 1.1
 * @since 2019
 */
public class Main {

    static List<Movie> movies = Movie.makeMoviesList();
    static List<Serie> series = Serie.makeSeriesList();
    static List<Book> books = Book.makeBooksList();
    static List<Magazine> magazines = Magazine.makeMagazinesList();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("\n:: WELCOME TO AMAZON VIEWER ::");
            System.out.println("  Please select one option:");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("0. Exit");

            option = scanner.next();
            switch (option) {
                case "1":
                    showMovies();
                    break;
                case "2":
                    showSeries();
                    break;
                case "3":
                    showBooks();
                    break;
                case "4":
                    showMagazines();
                    break;
                case "0":
                    System.out.println("\nThe execution has been finished.\n");
                    break;
                default:
                    System.out.println("\nThat option doesn't exist, please choose another.\n");
                    break;
            }
        } while (!option.equals("0"));
    }

    private static void showMovies() {
        String option;
        do {
            System.out.println("\n:: MOVIES ::\n");
            int index = 1;
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(i + 1 + ". " + movies.get(i).getTitle() + " Seen: " + movies.get(i).getViewed());
                index++;
            }
            System.out.println(index + ". Report");
            System.out.println(index + 1 + ". Report With Date");
            System.out.println("0. Return to Main Menu");

            option = Utils.validateUserResponseMenu(movies.size() + 2);
            if (option.equals(String.valueOf(index))) {
                StringBuilder content = new StringBuilder();
                for (Movie movie : movies) {
                    if (movie.getViewed().equals("Yes")) {
                        content.append(movie.toString()).append("\n");
                    }
                }
                makeReport(content.toString());
            } else if (option.equals(String.valueOf(index + 1))) {
                StringBuilder content = new StringBuilder();
                for (Movie movie : movies) {
                    if (movie.getViewed().equals("Yes")) {
                        content.append(movie.toString()).append("\n");
                    }
                }
                makeReport(content.toString(), new Date());
            } else if (!option.equals("0") && !option.equals("")) {
                Movie movieSelected = movies.get(Integer.parseInt(option) - 1);
                movieSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showSeries() {
        String option;
        do {
            System.out.println("\n:: SERIES ::\n");
            int index = 1;
            for (int i = 0; i < series.size(); i++) {
                System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Seen: " + series.get(i).getViewed());
                index++;
            }
            System.out.println(index + ". Report");
            System.out.println(index + 1 + ". Report With Date");
            System.out.println("0. Return to Main Menu");

            option = Utils.validateUserResponseMenu(series.size() + 2);
            if (option.equals(String.valueOf(index))) {
                StringBuilder content = new StringBuilder();
                for (Serie serie : series) {
                    if (serie.getViewed().equals("Yes")) {
                        content.append(serie.toString()).append("\n");
                    }
                }
                makeReport(content.toString());
            } else if (option.equals(String.valueOf(index + 1))) {
                StringBuilder content = new StringBuilder();
                for (Serie serie : series) {
                    if (serie.getViewed().equals("Yes")) {
                        content.append(serie.toString()).append("\n");
                    }
                }
                makeReport(content.toString(), new Date());
            } else if (!option.equals("0") && !option.equals("")) {
                System.out.println("\n:: SERIE " + option + " ::\n");
                Serie serie = series.get(Integer.parseInt(option) - 1);
                showChapters(serie.getChapters());
                serie.view();
            }
        } while (!option.equals("0"));
    }

    private static void showChapters(List<Chapter> chapters) {
        String option;
        do {
            System.out.println("\n:: CHAPTERS ::\n");
            int index = 1;
            for (int i = 0; i < chapters.size(); i++) {
                System.out.println(i + 1 + ". " + chapters.get(i).getTitle() + " Seen: " + chapters.get(i).getViewed());
                index++;
            }
            System.out.println(index + ". Report");
            System.out.println(index + 1 + ". Report With Date");
            System.out.println("0. Return to Main Menu");

            option = Utils.validateUserResponseMenu(chapters.size() + 2);
            if (option.equals(String.valueOf(index))) {
                StringBuilder content = new StringBuilder();
                for (Chapter chapter : chapters) {
                    if (chapter.getViewed().equals("Yes")) {
                        content.append(chapter.toString()).append("\n");
                    }
                }
                makeReport(content.toString());
            } else if (option.equals(String.valueOf(index + 1))) {
                StringBuilder content = new StringBuilder();
                for (Chapter chapter : chapters) {
                    if (chapter.getViewed().equals("Yes")) {
                        content.append(chapter.toString()).append("\n");
                    }
                }
                makeReport(content.toString(), new Date());
            } else if (!option.equals("0") && !option.equals("")) {
                Chapter chapterSelected = chapters.get(Integer.parseInt(option) - 1);
                chapterSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showBooks() {
        String option;
        do {
            System.out.println("\n:: BOOKS ::\n");
            int index = 1;
            for (int i = 0; i < books.size(); i++) {
                System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Read: " + books.get(i).isReaded());
                index++;
            }
            System.out.println(index + ". Report");
            System.out.println(index + 1 + ". Report With Date");
            System.out.println("0. Return to Main Menu");

            option = Utils.validateUserResponseMenu(books.size() + 2);
            if (option.equals(String.valueOf(index))) {
                StringBuilder content = new StringBuilder();
                for (Book book : books) {
                    if (book.isReaded().equals("Yes")) {
                        content.append(book.toString()).append("\n");
                    }
                }
                makeReport(content.toString());
            } else if (option.equals(String.valueOf(index + 1))) {
                StringBuilder content = new StringBuilder();
                for (Book book : books) {
                    if (book.isReaded().equals("Yes")) {
                        content.append(book.toString()).append("\n");
                    }
                }
                makeReport(content.toString(), new Date());
            } else if (!option.equals("0") && !option.equals("")) {
                Book bookSelected = books.get(Integer.parseInt(option) - 1);
                bookSelected.view();
            }
        } while (!option.equals("0"));
    }

    private static void showMagazines() {
        String option;
        do {
            System.out.println("\n:: MAGAZINES ::\n");
            int index = 1;
            for (int i = 0; i < magazines.size(); i++) {
                System.out.println(i + 1 + ". " + magazines.get(i).getTitle() + " Last Release: " +
                        new SimpleDateFormat("dd/MM/yyyy").format(magazines.get(i).getLastRelease()));
                index++;
            }
            System.out.println(index + ". Report");
            System.out.println(index + 1 + ". Report With Date");
            System.out.println("0. Return to Main Menu");

            option = Utils.validateUserResponseMenu(magazines.size() + 2);
            if (option.equals(String.valueOf(index))) {
                StringBuilder content = new StringBuilder();
                for (Magazine magazine : magazines) {
                    if (magazine.isReaded().equals("Yes")) {
                        content.append(magazines.toString()).append("\n");
                    }
                }
                makeReport(content.toString());
            } else if (option.equals(String.valueOf(index + 1))) {
                StringBuilder content = new StringBuilder();
                for (Magazine magazines : magazines) {
                    if (magazines.isReaded().equals("Yes")) {
                        content.append(magazines.toString()).append("\n");
                    }
                }
                makeReport(content.toString(), new Date());
            } else if (!option.equals("0") && !option.equals("")) {
                Magazine magazineSelected = magazines.get(Integer.parseInt(option) - 1);
                magazineSelected.setReaded(true);
                magazineSelected.startToSee(new Date());
                for (int i = 0; i < 100; i++) {
                    System.out.println("...You are reading the " + magazineSelected.getTitle() + "...");
                }
                Utils.timeDelay(2);
                System.out.println("\n::YOU JUST SAW::" + magazineSelected);
            }
        } while (!option.equals("0"));
    }

    private static void makeReport(String content) {
        System.out.println("\n:: CREATING REPORT WITHOUT DATE ::\n");
        Report report = new Report("Report.txt", ":: ALREADY SEEN ::\n");
        report.setContent(content);
        try {
            report.makeReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeReport(String content, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String dateFormat = simpleDateFormat.format(date);
        System.out.println("\n:: REPORT DATED " + date + " ::\n");
        Report report = new Report("Report-" + dateFormat + ".txt", ":: ALREADY SEEN ::\n");
        report.setContent(content);
        try {
            report.makeReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
