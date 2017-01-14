package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hojun on 2016-11-09.
 */
public class BoardListInfoDTO {
    @SerializedName("writenum")
    private int writenum;
    @SerializedName("cgcode")
    private String cgcode;
    @SerializedName("bdcode")
    private String bdcode;
    @SerializedName("subject")
    private String subject;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("regdate")
    private String regdate;
    @SerializedName("moddate")
    private String moddate;
    @SerializedName("content")
    private String content;
    @SerializedName("readcnt")
    private int readcnt;
    @SerializedName("likes")
    private int likes;
    @SerializedName("ip")
    private String ip;
    @SerializedName("replycnt")
    private int replycnt;

    public int getWritenum() {
        return writenum;
    }

    public void setWritenum(int writenum) {
        this.writenum = writenum;
    }

    public String getCgcode() {
        return cgcode;
    }

    public void setCgcode(String cgcode) {
        this.cgcode = cgcode;
    }

    public String getBdcode() {
        return bdcode;
    }

    public void setBdcode(String bdcode) {
        this.bdcode = bdcode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReadcnt() {
        return readcnt;
    }

    public void setReadcnt(int readcnt) {
        this.readcnt = readcnt;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReplycnt() {
        return replycnt;
    }

    public void setReplycnt(int replycnt) {
        this.replycnt = replycnt;
    }
}
