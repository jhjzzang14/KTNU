package com.ktnu.ktnuapp.Retrofit;

import com.ktnu.ktnuapp.DTO.BoardLargeDTO;
import com.ktnu.ktnuapp.DTO.BoardListDTO;
import com.ktnu.ktnuapp.DTO.BoardMediumDTO;
import com.ktnu.ktnuapp.DTO.MessageDTO;

import java.util.List;

import retrofit.Call;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Query;

/**
 * Created by hojun on 2016-11-05.
 */
public interface BoardApi {
    //대분류 게시판 정보 요청
    @GET("/LargeBoardList")
    Call<List<BoardLargeDTO>> getBoardName();

    //중분류 게시판 정보 요청
    @GET("/MediumBoardList")
    Call<List<BoardMediumDTO>> getBoardMiddleName(@Query("cgcode") String id);

    //게시판 목록 정보 요청
    @GET("/dumpContentsList")
    Call<List<BoardListDTO>> getBoardList(@Query("bdcode") String bdcode);


    //게시글 등록
    @FormUrlEncoded
    @POST("/newContents")
    Call<MessageDTO> postBoardContents(@Field("cgcode")String cgcode, @Field("bdcode")String bdcode,
                                       @Field("subject")String subject,
                                       @Field("nickname")String nickname,
                                       @Field("content")String content);
    //게시글 읽기
    @GET("/dumpContents")
    Call<List<BoardListDTO>> getBoardReadList(@Query("writenum")int writenum);

    //게시글 삭제
    @DELETE("/deleteContents")
    Call<MessageDTO> deleteBoard(@Query("writenum")String writenum);

    //게시글 수정
    @PUT("/modifyContents")
    Call<List<MessageDTO>> modifyBoardContents(@Field("cgcode")String cgcode,@Field("bdcode")String bdcode,
                                               @Field("subject")String subject, @Field("nickname")String nickname,
                                               @Field("content")String content);
}
