package com.homesetprueba;

import android.app.Application;
import com.homesetprueba.api.ApiManager;

public class BaseApplication extends Application {

    private static BaseApplication instance;
    public static ApiManager apiManager;

    public static BaseApplication getInstance() {
        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance(this);
    }

}
