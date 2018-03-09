package com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Proxim on 2/27/2018.
 */

public class NoticesDatum implements Serializable {

        @SerializedName("companyids")
        @Expose
        private List<Companyid> companyids = null;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("titletype")
        @Expose
        private String titletype;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public List<Companyid> getCompanyids() {
            return companyids;
        }

        public void setCompanyids(List<Companyid> companyids) {
            this.companyids = companyids;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitletype() {
            return titletype;
        }

        public void setTitletype(String titletype) {
            this.titletype = titletype;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

}
