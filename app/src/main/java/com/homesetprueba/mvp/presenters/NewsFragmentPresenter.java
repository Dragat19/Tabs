package com.homesetprueba.mvp.presenters;


import android.util.Log;

import com.homesetprueba.api.*;
import com.homesetprueba.api.response.NewsResponse;
import com.homesetprueba.mvp.views.NewsView;

public class NewsFragmentPresenter extends BasePresenter<NewsView> {

    private int nextPage;
    private boolean canLoadMore;

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
            nextPage = nextPage + 1;
            if (news.getEmpty() == 1) {
                canLoadMore = false;
            }
            if (canLoadMore) {
                mvpView.onDataUpdate(news.getData());
            }
        }
    };

    public void getNews(String idCategory) {
        init();
        compositeSubscription.add(BaseApplication.apiManager.getNews(idCategory, nextPage).subscribe(observer));
    }

    private void init() {
        nextPage = 1;
        canLoadMore = true;
    }
}
