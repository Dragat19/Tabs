package com.homesetprueba.mvp.views;

import com.homesetprueba.mvp.model.News;

import java.util.ArrayList;

public interface NewsView extends MvpView{

    void onDataUpdate(ArrayList<News> news);

    void onError(String error);

    void onHttpError(int errorCode, String meg);
}
