package com.erosennin.amazonviewer.challenges;

public class Album {

    private String name;
    private String author;
    private int year;
    private Song[] songs;

//    String[] songNames = {"Uno", "Divenire", "Monday", "Andare", "Rose", "Primavera", "Oltremare", "L'origine Nascosta", "Fly", "Ascolta", "Ritornare", "Svanire"};
//    int[] songDurations = {228, 402, 355, 422, 256, 444, 660, 192, 279, 289, 532, 449};
//    Album album = new Album("Divenire","Ludovico Einaudi",2006, songNames, songDurations);
//    System.out.println(album);

    public Album(String name, String author, int year, String[] songNames, int[] songDurations) {
        this.name = name;
        this.author = author;
        this.year = year;
        setAlbum(songNames, songDurations);
    }

    private void setAlbum(String[] names, int[] durations) {
        Song[] songs = new Song[names.length];
        for (int i = 0; i < names.length; i++) {
            songs[i] = new Song(names[i], durations[i]);
        }
        this.songs = songs;
    }

    private String getAlbum() {
        StringBuilder sb = new StringBuilder();
        for (Song song : songs) {
            sb.append(song);
        }
        return sb.toString();
    }

    public String toString() {
        return "\nALBUM: " + name +
                "\nAUTHOR: " + author +
                "\nYEAR: " + year +
                "\n\n::SONGS::\n" + getAlbum();
    }


    private static class Song {

        private String name;
        private int duration;

        private Song(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }

        public String toString() {
            return "\nName: " + name +
                    "\nDuration: " + duration + " seconds\n";
        }
    }
}
