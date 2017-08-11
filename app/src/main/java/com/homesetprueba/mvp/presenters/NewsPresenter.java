package com.homesetprueba.mvp.presenters;


import android.util.Log;

import com.homesetprueba.BaseApplication;
import com.homesetprueba.api.*;
import com.homesetprueba.api.response.NewsResponse;
import com.homesetprueba.mvp.views.NewsView;

public class NewsPresenter extends BasePresenter<NewsView> {

    private CustomObserver<NewsResponse> observer = new CustomObserver<NewsResponse>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("ERRORAPI", e.getMessage());
            super.onError(e);
        }

        @Override
        public void onNoInternetConnection() {
            mvpView.onError("noInternetConnection");
        }

        @Override
        public void onUnknownError() {
            mvpView.onError("uknownError");
        }

        @Override
        public void onTimeOut() {
            mvpView.onError("timeOut");
        }

        @Override
        public void onHttpErrorCode(int errorCode, String meg) {
            mvpView.onHttpError(errorCode, meg);
        }

        @Override
        public void onNext(NewsResponse news) {
            super.onNext(news);
            mvpView.onDataUpdate(news.getData());
        }
    };

    public void getNews(String idCategory) {
        compositeSubscription.add(BaseApplication.requestController.getNews(idCategory, 1).subscribe(observer));
    }


}
