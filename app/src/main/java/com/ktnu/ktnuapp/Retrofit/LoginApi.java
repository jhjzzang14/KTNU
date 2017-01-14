package com.ktnu.ktnuapp.Retrofit;

import com.ktnu.ktnuapp.DTO.MessageDTO;
import com.ktnu.ktnuapp.DTO.MyInfoDTO;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by hojun on 2016-11-06.
 */
public interface LoginApi {

    //로그인 요청
    @FormUrlEncoded
    @POST("/userLogin")
    Call<MyInfoDTO> postLogin(@Field("hnum") String id, @Field("pwd") String pwd);

    //회원가입 요청
    @FormUrlEncoded
    @POST("/memberJoin")
    Call<MessageDTO> postJoin(@Field("nickname") String nickname, @Field("hnum") int hnum, @Field("department") String department,
                              @Field("username") String username, @Field("password") String password, @Field("email") String email,
                              @Field("tel") String id);

    //중복 확인 요청
    @GET("/overlap")
    Call<MessageDTO> getOverlap(@Query("hnum") String hnum);

}
