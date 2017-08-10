package com.homesetprueba.api.response;

;

import com.homesetprueba.mvp.model.News;

import java.util.ArrayList;

public class NewsResponse {
    private int empty;
    private ArrayList<News> data;

    public int getEmpty() {
        return empty;
    }

    public ArrayList<News> getData() {
        return data;
    }
}
