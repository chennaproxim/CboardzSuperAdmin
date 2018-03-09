package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Proxim on 3/7/2018.
 */

public class Businessheadlist implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("businessheadname")
    @Expose
    private String businessheadname;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("companyid")
    @Expose
    private String companyid;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessheadname() {
        return businessheadname;
    }

    public void setBusinessheadname(String businessheadname) {
        this.businessheadname = businessheadname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
