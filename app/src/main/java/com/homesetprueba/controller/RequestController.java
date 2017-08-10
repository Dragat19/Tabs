package com.homesetprueba.controller;

import android.content.Context;

import com.homesetprueba.api.response.HomeResponse;
import com.homesetprueba.api.response.NewsResponse;
import com.homesetprueba.api.RequestApiEndpoints;
import com.homesetprueba.utils.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RequestController {

    private static RequestApiEndpoints apiServiceAsync;
    private static RequestController instance;
    private static final int TIMEOUT_MILLIS = 10000;
    private final static String BASE_URL_APPS = "http://apps.playtown.mx/set_br/";
    private static final TimeUnit TIMEOUT_UNIT = TimeUnit.MILLISECONDS;
    private Context context;

    private RequestController(Context context) {

        this.context = context;
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Retrofit retrofitAsync = new Retrofit.Builder()
                .baseUrl(BASE_URL_APPS)
                .client(createDefaultOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        apiServiceAsync = retrofitAsync.create(RequestApiEndpoints.class);
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

    public static RequestController getInstance(Context context) {
        if (instance == null) {
            instance = new RequestController(context);
        }
        return instance;
    }

    public Observable<ResponseBody> logSMS(String param1, String param2) {
        return apiServiceAsync.exampleCall(param1, param2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<NewsResponse> getNews(String idCategory, int page) {
        return apiServiceAsync.getNews(idCategory,page).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<HomeResponse> getHome() {
        return apiServiceAsync.getHome().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
