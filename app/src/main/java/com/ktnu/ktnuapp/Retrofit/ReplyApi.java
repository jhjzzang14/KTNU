package com.ktnu.ktnuapp.Retrofit;

import com.ktnu.ktnuapp.DTO.MessageDTO;
import com.ktnu.ktnuapp.DTO.ReplyDTO;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Query;

/**
 * Created by hojun on 2016-11-08.
 */
public interface ReplyApi {

    //댓글 목록 불러오기
    @GET("/DumpReply")
    Call<List<ReplyDTO>> getReplyList(@Query("writenum") int writenum);

    //댓글 쓰기
    @FormUrlEncoded
    @POST("/newReply")
    Call<MessageDTO> postReplyList(@Field("writenum")int writenum, @Field("nickname")String nickname, @Field("bdcode")String bdcode, @Field("comment")String comment, @Field("ip")String ip);

    //댓글 수정
    @PUT("/putReplyList")
    Call<MessageDTO> putReplyList(@Body ReplyDTO replyDTO);

    //댓글 삭제
    @DELETE("/deleteReplyList")
    Call<MessageDTO> deleteReplyList(@Query("id")String id);
}
