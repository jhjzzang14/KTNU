package com.ktnu.ktnuapp.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hojun on 2016-11-06.
 */
public class MessageDTO {
    @SerializedName("code")
    private String code;
    @SerializedName("message")
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
