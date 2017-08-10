package com.homesetprueba.mvp.model;

/**
 * Created by albertsanchez on 10/8/17.
 */

public class NewsTest {

    private String titleNews;
    private String subTitlesNews;
    private String urlNews;
    private int img;

    public NewsTest(String titleNews) {
        this.titleNews = titleNews;
    }

    public int getImg() {
        return img;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getSubTitlesNews() {
        return subTitlesNews;
    }

    public String getUrlNews() {
        return urlNews;
    }
}
