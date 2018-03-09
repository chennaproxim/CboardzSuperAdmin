package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Proxim on 3/7/2018.
 */

public class BusinessHeadDepartmentListDTO implements Serializable {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("res")
    @Expose
    private Boolean res;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("businessheadlist")
    @Expose
    private List<Businessheadlist> businessheadlist = null;
    @SerializedName("departmentlist")
    @Expose
    private List<Departmentlist> departmentlist = null;

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

    public List<Businessheadlist> getBusinessheadlist() {
        return businessheadlist;
    }

    public void setBusinessheadlist(List<Businessheadlist> businessheadlist) {
        this.businessheadlist = businessheadlist;
    }

    public List<Departmentlist> getDepartmentlist() {
        return departmentlist;
    }

    public void setDepartmentlist(List<Departmentlist> departmentlist) {
        this.departmentlist = departmentlist;
    }
}
