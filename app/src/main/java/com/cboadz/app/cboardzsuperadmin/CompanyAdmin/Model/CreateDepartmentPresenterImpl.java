package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateDepartmentDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeListDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateDepartmentPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateDepartmentView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/6/2018.
 */

public class CreateDepartmentPresenterImpl implements CreateDepartmentPresenter {

    private CreateDepartmentView mCreateDepartmentView;

    public CreateDepartmentPresenterImpl(CreateDepartmentView createDepartmentView) {

        this.mCreateDepartmentView = createDepartmentView;
    }

    @Override
    public void createDepartment(String departmentname, String employeeid, String personname, String companyemail
            , String phonenumber, String reportto, String token, String companyid) {

        JsonObject json = new JsonObject();
        json.addProperty("departmentname", departmentname);
        json.addProperty("employeeid", employeeid);
        json.addProperty("personname", personname);
        json.addProperty("companyemail", companyemail);
        json.addProperty("phonenumber", phonenumber);
        json.addProperty("reportto", reportto);
        json.addProperty("token", token);
        json.addProperty("companyid", companyid);

        Ion.with((Context) mCreateDepartmentView)
                .load(AppConstants.CREATEDEPARTMENT)
                .setJsonObjectBody(json)
                .as(new TypeToken<CreateDepartmentDTO>() {
                })
                .setCallback(new FutureCallback<CreateDepartmentDTO>() {
                    @Override
                    public void onCompleted(Exception e, CreateDepartmentDTO result) {
                        if (result != null) {
                            try {
                                mCreateDepartmentView.showCreateDepartmentResponce(result);

                            } catch (Exception ex) {
                                mCreateDepartmentView.onError(result.getResponse());
                                ex.printStackTrace();
                            }
                        }
                    }
                });

    }
}
