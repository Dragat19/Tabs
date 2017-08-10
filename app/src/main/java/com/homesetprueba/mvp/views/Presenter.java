package com.homesetprueba.mvp.views;


public interface Presenter<T> {
    void attachMvpView(T mvpView);
    void detachMvpView();
}
