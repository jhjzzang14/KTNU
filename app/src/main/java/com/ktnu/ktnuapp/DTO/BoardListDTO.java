package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hojun on 2016-11-06.
 * 게시판 목록 속성
 */
public class BoardListDTO {

    //글번호
    @SerializedName("writenum")
    private int writenum;
    //대분류 게시판 코드 번호
    @SerializedName("cgcode")
    private String cgcode;
    //중분류 게시판 코드 번호
    @SerializedName("bdcode")
    private String bdcode;
    //제목
    @SerializedName("subject")
    private String subject;
    //닉네임
    @SerializedName("nickname")
    private String nickname;
    //게시일
    @SerializedName("regdate")
    private String regdate;
    //수저일
    @SerializedName("moddate")
    private String moddate;
    //내용
    @SerializedName("content")
    private String content;
    //조회수
    @SerializedName("readcnt")
    private int readcnt;
    //좋아요 수
    @SerializedName("likes")
    private int likes;
    // 안쓰임
    @SerializedName("ip")
    private String ip;
    //댓글 갯수수    @SerializedName("replycnt")
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
