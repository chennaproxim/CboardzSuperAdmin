package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter;

import java.io.File;

/**
 * Created by chinn on 02/21/18.
 */

public interface CreateCompanyPresenter {

    void sendComapnyData(String companyname, String gst, String companyregno, String companyphoneno, String description, String hrheademail,
                         String companyemail, String rootadministratoremail, String yearofestablish, String website,
                         String linke, String industry, String password, String token, File logo,File coverimage);
}
