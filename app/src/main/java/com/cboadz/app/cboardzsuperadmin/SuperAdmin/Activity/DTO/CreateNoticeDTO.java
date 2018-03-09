package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Proxim on 2/28/2018.
 */

public class CreateNoticeDTO implements Serializable {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("res")
    @Expose
    private Boolean res;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("id")
    @Expose
    private String id;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
