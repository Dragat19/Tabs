package com.homesetprueba.mvp.views;


import com.homesetprueba.mvp.model.Module;

import java.util.ArrayList;

public interface HomeView extends MvpView {

    void onError(String error);

    void onHttpError(int errorCode, String meg);

    void onDataUpdate(ArrayList<Module> modules);

}
