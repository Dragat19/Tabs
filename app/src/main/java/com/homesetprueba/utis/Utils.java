package com.homesetprueba.utis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.UrlQuerySanitizer;
import android.provider.SyncStateContract;

import com.homesetprueba.R;


public class Utils {


    public static String getParam(String param, String url) {
        UrlQuerySanitizer sanitzer = new UrlQuerySanitizer(url);
        return sanitzer.getValue(param);
    }

    public static boolean hasInternet(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}