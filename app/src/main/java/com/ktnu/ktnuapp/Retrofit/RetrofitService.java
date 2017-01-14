package com.ktnu.ktnuapp.Retrofit;

import com.ktnu.ktnuapp.Retrofit.BoardApi;
import com.ktnu.ktnuapp.Retrofit.LoginApi;
import com.ktnu.ktnuapp.Retrofit.ReplyApi;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by hojun on 2016-11-06.
 */
public class RetrofitService {

    //도메인 주소 ex) http://localhost:3000
    private String url="http://호스트 ip:포트 번호";

    //Board Api Config
    public BoardApi getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BoardApi service =  retrofit.create(BoardApi.class);
        return service;
    }

    //Login Api Config
    public LoginApi getLoginService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginApi service =  retrofit.create(LoginApi.class);
        return service;
    }

    //Reply Api Config
    public ReplyApi getReplyService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReplyApi service =  retrofit.create(ReplyApi.class);
        return service;
    }

}
