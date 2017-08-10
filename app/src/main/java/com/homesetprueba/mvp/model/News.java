package com.homesetprueba.mvp.model;


import java.util.ArrayList;

public class News {

    private int id;
    private String title;
    private String date;
    private String category;
    private String preview;
    private String content;
    private String comments;

    private ArrayList<Integer> tagss;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getPreview() {
        return preview;
    }

    public String getContent() {
        return content;
    }

    public String getComments() {
        return comments;
    }

    public ArrayList<Integer> getTags() {
        return new ArrayList<>();
    }
}
