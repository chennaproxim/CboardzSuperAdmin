package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface CreateDepartmentPresenter {

    void createDepartment(String departmentname, String employeeid, String personname, String companyemail, String phonenumber
            , String reportto, String token, String companyid);
}
