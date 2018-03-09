package com.cboadz.app.cboardzsuperadmin.Employees.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.Employees.DTO.EmployeeProfileResponse;
import com.cboadz.app.cboardzsuperadmin.Employees.Presenter.EmployeeProfilePresenter;
import com.cboadz.app.cboardzsuperadmin.Employees.View.EmployeeProfileView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/6/2018.
 */

public class EmployeeProfilePresenterImpl implements EmployeeProfilePresenter {

    private EmployeeProfileView mEmployeeProfileView;

    public EmployeeProfilePresenterImpl(EmployeeProfileView employeeProfileView){

        this.mEmployeeProfileView = employeeProfileView;
    }

    @Override
    public void sendEmployeeProfileData(String token, String id) {

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("token", token);

        Ion.with((Context) mEmployeeProfileView)
                .load(AppConstants.EMPLOYEEPROFILE)
                .setJsonObjectBody(json)
                .as(new TypeToken<EmployeeProfileResponse>() {})
                .setCallback(new FutureCallback<EmployeeProfileResponse>() {
                    @Override
                    public void onCompleted(Exception e, EmployeeProfileResponse result) {
                        if (result != null) {
                            try {
                                mEmployeeProfileView.showEmployeeProfile(result);

                            } catch (Exception ex) {
                                mEmployeeProfileView.onError(result.getResponse());
                                ex.printStackTrace();

                            }
                        }
                    }
                });



    }
}
