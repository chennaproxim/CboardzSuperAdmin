package com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Proxim on 2/27/2018.
 */

public class NoticesResult implements Serializable {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("res")
    @Expose
    private Boolean res;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("data")
    @Expose
    private List<NoticesDatum> data = null;

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

    public List<NoticesDatum> getData() {
        return data;
    }

    public void setData(List<NoticesDatum> data) {
        this.data = data;
    }

}
