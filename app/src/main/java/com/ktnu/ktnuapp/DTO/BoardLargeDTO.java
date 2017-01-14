package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hojun on 2016-11-05.
 * 대분류 게시판 속성
 */
public class BoardLargeDTO {
    //대분류 게시판 코드 #PrimaryKey
    @SerializedName("cgcode")
    private String id;
    //대분류 게시판 이름
    @SerializedName("cgname")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
