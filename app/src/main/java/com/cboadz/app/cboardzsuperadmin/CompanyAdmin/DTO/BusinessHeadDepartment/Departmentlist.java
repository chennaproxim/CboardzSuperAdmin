package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Proxim on 3/7/2018.
 */

public class Departmentlist implements Serializable{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("employeeid")
    @Expose
    private String employeeid;
    @SerializedName("personname")
    @Expose
    private String personname;
    @SerializedName("companyemail")
    @Expose
    private String companyemail;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("reportto")
    @Expose
    private Object reportto;
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

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Object getReportto() {
        return reportto;
    }

    public void setReportto(Object reportto) {
        this.reportto = reportto;
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
