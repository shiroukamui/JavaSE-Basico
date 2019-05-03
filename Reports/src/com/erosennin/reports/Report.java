package com.erosennin.reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Report {

    private String nameFile;
    private String content;
    private String title;

    public Report(String nameFile, String title) {
        this.nameFile = nameFile;
        this.title = title;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void makeReport() throws IOException {
        if (getContent() == null || getNameFile() == null || getTitle() == null) {
            System.out.println("File data is empty, please filled out them");
        } else {
            FileOutputStream file = new FileOutputStream(getNameFile());
            file.write(getTitle().getBytes(StandardCharsets.UTF_8));
            file.write(getContent().getBytes(StandardCharsets.UTF_8));
            file.close();
        }
    }
}
