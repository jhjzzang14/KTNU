package com.ktnu.ktnuapp.Retrofit;

import com.ktnu.ktnuapp.DTO.BoardListDTO;
import com.ktnu.ktnuapp.DTO.ProfileDTO;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by hojun on 2016-11-09.
 */
public interface ProfileApi {
    //사용자 프로필 정보 가지고 오기
    @GET("/getProfileInfo")
    Call<ProfileDTO> getProfileInfo(@Query("nickname")String nickname);

    //사용자 게시글 가지고 오기
    @GET("/getProfileInfo")
    Call<List<BoardListDTO>> getBoardInfo(@Query("nickname")String nickname);
}
