package com.homesetprueba.api;


import com.homesetprueba.api.response.HomeResponse;
import com.homesetprueba.api.response.NewsResponse;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RequestApiEndpoints {

    @GET("public//?action=log_sms")
    Observable<ResponseBody> exampleCall(@Query("param1") String param1, @Query("param2") String param2);

    @GET("public//?action=get_home")
    Observable<HomeResponse> getHome();

    //http://apps.playtown.mx/set_br/public//?action=get_home
    @GET("public//?action=get_news")
    Observable<NewsResponse> getNews(@Query("category") String idCategory, @Query("page") int nextPage);

}