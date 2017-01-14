package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hojun on 2016-11-10.
 */
public class MyInfoDTO {
    @SerializedName("hnum")
    private int hnum;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("message")
    private String message;

    public int getHnum() {
        return hnum;
    }

    public void setHnum(int hnum) {
        this.hnum = hnum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
