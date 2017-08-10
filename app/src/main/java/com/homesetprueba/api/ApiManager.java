package com.homesetprueba.api;

import android.content.Context;

import com.homesetprueba.utis.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by albertsanchez on 10/8/17.
 */

public class ApiManager {

    private static ApiEndpoints apiServiceAsync;
    private static ApiManager instance;
    private static final int TIMEOUT_MILLIS = 10000;
    private final static String BASE_URL_APPS = "http://apps.playtown.mx/set_br/";
    private static final TimeUnit TIMEOUT_UNIT = TimeUnit.MILLISECONDS;
    private Context context;

    private ApiManager(Context context) {

        this.context = context;
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofitAsync = new Retrofit.Builder()
                .baseUrl(BASE_URL_APPS)
                .client(createDefaultOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        apiServiceAsync = retrofitAsync.create(ApiEndpoints.class);
    }


    private OkHttpClient createDefaultOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient().newBuilder()
                .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024)) // 10 MB
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (Utils.hasInternet(context)) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24).build();
                        }
                        return chain.proceed(request);
                    }
                })
                .connectTimeout(TIMEOUT_MILLIS, TIMEOUT_UNIT)
                .readTimeout(TIMEOUT_MILLIS, TIMEOUT_UNIT)
                .writeTimeout(TIMEOUT_MILLIS, TIMEOUT_UNIT)
                .addInterceptor(interceptor)
                .build();
    }

    public static ApiManager getInstance(Context context) {
        if (instance == null) {
            instance = new ApiManager(context);
        }
        return instance;
    }
}
