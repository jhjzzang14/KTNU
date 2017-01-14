package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by hojun on 2016-11-09.
 */
public class ReplyDTO {
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("hnum")
    private int hnum;
    @SerializedName("writenum")
    private int writenum;
    @SerializedName("bdcode")
    private String bdcode;
    @SerializedName("comment")
    private String comment;
    @SerializedName("regdate")
    private String regdate;
    @SerializedName("moddate")
    private String moddate;
    @SerializedName("ip")
    private String ip;

    public ReplyDTO(int writenum,String nickname, String bdcode, String comment,String ip) {
        this.writenum = writenum;
        this.nickname = nickname;
        this.bdcode = bdcode;
        this.comment = comment;
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getHnum() {
        return hnum;
    }

    public void setHnum(int hnum) {
        this.hnum = hnum;
    }

    public int getWritenum() {
        return writenum;
    }

    public void setWritenum(int writenum) {
        this.writenum = writenum;
    }

    public String getBdcode() {
        return bdcode;
    }

    public void setBdcode(String bdcode) {
        this.bdcode = bdcode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getModdate() {
        return moddate;
    }

    public void setModdate(String moddate) {
        this.moddate = moddate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
