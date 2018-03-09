package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter;

/**
 * Created by Proxim on 3/1/2018.
 */

public interface EditCompanyPresenter {

    void sendeditCompanyData(String id, String companyname, String gst, String companyregno, String companyphoneno, String description
            , String hrheademail, String companyemail, String rootadministratoremail, String yearofestablish, String website, String linke, String industry, String token);
}
