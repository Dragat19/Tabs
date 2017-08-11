package com.homesetprueba.mvp.presenters;


import com.homesetprueba.BaseApplication;
import com.homesetprueba.api.CustomObserver;
import com.homesetprueba.api.response.HomeResponse;
import com.homesetprueba.mvp.views.HomeView;

public class HomePresenter extends BasePresenter<HomeView> {

    private CustomObserver<HomeResponse> observer = new CustomObserver<HomeResponse>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
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
        public void onNext(HomeResponse modules) {
            super.onNext(modules);
            mvpView.onDataUpdate(modules.getModules());
        }
    };

    public void getHome() {
        compositeSubscription.add(BaseApplication.requestController.getHome().subscribe(observer));
    }

}
