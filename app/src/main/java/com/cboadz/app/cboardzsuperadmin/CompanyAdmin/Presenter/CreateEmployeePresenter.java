package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter;

import java.io.File;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface CreateEmployeePresenter {

    void sendEmployeeDetails(String employeeid, String firstname, String lastname, String companyemail, String phone
            , String department, String designation, String address, String bloodgroup, String reportingmanager, String gender
            , String personalemail, String statustype, String token, File profilephoto, String companyid, String password);
}
