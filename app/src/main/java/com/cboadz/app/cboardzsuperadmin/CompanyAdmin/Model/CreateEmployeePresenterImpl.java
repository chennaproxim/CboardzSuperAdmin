package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateEmployeeDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateEmployeePresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateEmployeeView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;

import java.io.File;

/**
 * Created by Proxim on 3/6/2018.
 */

public class CreateEmployeePresenterImpl implements CreateEmployeePresenter {

    private CreateEmployeeView mCreateEmployeeView;

    public CreateEmployeePresenterImpl(CreateEmployeeView createEmployeeView) {

        this.mCreateEmployeeView = createEmployeeView;
    }

    @Override
    public void sendEmployeeDetails(String employeeid, String firstname, String lastname, String companyemail
            , String phone, String department, String designation, String address, String bloodgroup
            , String reportingmanager, String gender, String personalemail, String statustype, String token
            , File profilephoto, String companyid, String password) {

        Ion.with((Context) mCreateEmployeeView)
                .load(AppConstants.CREATEEMPLOYEE)
                .uploadProgress(new ProgressCallback() {
                    @Override
                    public void onProgress(long downloaded, long total) {

                    }
                })
                .setMultipartParameter("employeeid", employeeid)
                .setMultipartParameter("firstname", firstname)
                .setMultipartParameter("lastname", lastname)
                .setMultipartParameter("companyemail", companyemail)
                .setMultipartParameter("phone", phone)
                .setMultipartParameter("department", department)
                .setMultipartParameter("designation", designation)
                .setMultipartParameter("address", address)
                .setMultipartParameter("bloodgroup", bloodgroup)
                .setMultipartParameter("reportingmanager", reportingmanager)
                .setMultipartParameter("gender", gender)
                .setMultipartParameter("personalemail", personalemail)
                .setMultipartParameter("statustype", statustype)
                .setMultipartParameter("token", token)
                .setMultipartParameter("companyid", companyid)
                .setMultipartParameter("password", password)
                .setMultipartFile("profilephoto", "image/jpeg", profilephoto)
                .as(new TypeToken<CreateEmployeeDTO>() {
                })
                .setCallback(new FutureCallback<CreateEmployeeDTO>() {
                    @Override
                    public void onCompleted(Exception e, CreateEmployeeDTO result) {
                        try {
                            if (result.getRes().equals("false")) {
                                mCreateEmployeeView.onError(result.getResponse());
                            } else {
                                mCreateEmployeeView.showEmployeeCreatedStatus(result);
                            }

                        } catch (Exception exception) {
                            mCreateEmployeeView.onError("Error ");
                            exception.printStackTrace();
                        }

                    }
                });
    }
}
