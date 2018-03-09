package com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by chinn on 02/21/18.
 */

public class CompanyListData implements Serializable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("companyname")
    @Expose
    private String companyname;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("yearofestablish")
    @Expose
    private String yearofestablish;
    @SerializedName("companyregno")
    @Expose
    private String companyregno;
    @SerializedName("gst")
    @Expose
    private String gst;
    @SerializedName("hrheademail")
    @Expose
    private String hrheademail;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("linke")
    @Expose
    private String linke;
    @SerializedName("companyemail")
    @Expose
    private String companyemail;
    @SerializedName("companyphoneno")
    @Expose
    private String companyphoneno;
    @SerializedName("industry")
    @Expose
    private String industry;
    @SerializedName("rootadministratoremail")
    @Expose
    private String rootadministratoremail;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("coverimage")
    @Expose
    private String coverimage;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearofestablish() {
        return yearofestablish;
    }

    public void setYearofestablish(String yearofestablish) {
        this.yearofestablish = yearofestablish;
    }

    public String getCompanyregno() {
        return companyregno;
    }

    public void setCompanyregno(String companyregno) {
        this.companyregno = companyregno;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getHrheademail() {
        return hrheademail;
    }

    public void setHrheademail(String hrheademail) {
        this.hrheademail = hrheademail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLinke() {
        return linke;
    }

    public void setLinke(String linke) {
        this.linke = linke;
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail;
    }

    public String getCompanyphoneno() {
        return companyphoneno;
    }

    public void setCompanyphoneno(String companyphoneno) {
        this.companyphoneno = companyphoneno;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRootadministratoremail() {
        return rootadministratoremail;
    }

    public void setRootadministratoremail(String rootadministratoremail) {
        this.rootadministratoremail = rootadministratoremail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "CompanyListData{" +
                "id='" + id + '\'' +
                ", companyname='" + companyname + '\'' +
                ", description='" + description + '\'' +
                ", yearofestablish='" + yearofestablish + '\'' +
                ", companyregno='" + companyregno + '\'' +
                ", gst='" + gst + '\'' +
                ", hrheademail='" + hrheademail + '\'' +
                ", website='" + website + '\'' +
                ", linke='" + linke + '\'' +
                ", companyemail='" + companyemail + '\'' +
                ", companyphoneno='" + companyphoneno + '\'' +
                ", industry='" + industry + '\'' +
                ", rootadministratoremail='" + rootadministratoremail + '\'' +
                ", logo='" + logo + '\'' +
                ", coverimage='" + coverimage + '\'' +
                ", v=" + v +
                '}';
    }
}
