package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeListDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.EmployeeListPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.EmployeeListView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/5/2018.
 */

public class EmployeeListPresenterImpl implements EmployeeListPresenter {

    private EmployeeListView memployeeListView;

    public EmployeeListPresenterImpl(EmployeeListView employeeListView){
        this.memployeeListView = employeeListView;
    }

    @Override
    public void sendEmployeesData(String id, String token) {


        JsonObject json = new JsonObject();
        json.addProperty("companyid", id);
        json.addProperty("token", token);

        Ion.with((Context) memployeeListView)
                .load(AppConstants.EMPLIST)
                .setJsonObjectBody(json)
                .as(new TypeToken<EmployeeListDTO>() {})
                .setCallback(new FutureCallback<EmployeeListDTO>() {
                    @Override
                    public void onCompleted(Exception e, EmployeeListDTO result) {
                        if (result != null) {
                            try {
                                memployeeListView.showEmployeesList(result.getData());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                memployeeListView.onError(result.getResponse());
                            }
                        }
                        else {
                            memployeeListView.onError("No Data Found ");
                        }
                    }
                });

    }
}
