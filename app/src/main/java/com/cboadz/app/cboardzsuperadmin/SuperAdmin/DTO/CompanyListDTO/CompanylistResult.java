package com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chinn on 02/21/18.
 */

public class CompanylistResult implements Serializable{

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
    private List<CompanyListData> data = null;

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

    public List<CompanyListData> getData() {
        return data;
    }

    public void setData(List<CompanyListData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CompanylistResult{" +
                "response='" + response + '\'' +
                ", res=" + res +
                ", statuscode=" + statuscode +
                ", data=" + data +
                '}';
    }
}
