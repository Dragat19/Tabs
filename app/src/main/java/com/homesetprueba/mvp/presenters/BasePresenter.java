package com.homesetprueba.mvp.presenters;

import com.homesetprueba.mvp.views.MvpView;
import com.homesetprueba.mvp.views.Presenter;

import rx.subscriptions.CompositeSubscription;


public class BasePresenter <T extends MvpView> implements Presenter<T> {

    protected T mvpView;

    protected CompositeSubscription compositeSubscription;

    @Override
    public void attachMvpView(T mvpView) {
        this.mvpView = mvpView;
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachMvpView() {
        this.mvpView = null;
        if (this.compositeSubscription != null) this.compositeSubscription.clear();
    }
}
