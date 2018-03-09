package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.CompanyProfileDTO.CompanyProfielResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Presenter.CompanyProfilePresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View.CompanyProfileView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/1/2018.
 */

public class CompanyProfilePresenterImpl implements CompanyProfilePresenter {

    private CompanyProfileView mcompanyProfileView;

    public CompanyProfilePresenterImpl(CompanyProfileView companyProfileView) {

        this.mcompanyProfileView = companyProfileView;
    }

    @Override
    public void sendCompanyId(String id, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("token", token);

        Ion.with((Context) mcompanyProfileView)
                .load(AppConstants.COMPANYPROFILE)
                .setJsonObjectBody(json)
                .as(new TypeToken<CompanyProfielResult>() {

                })
                .setCallback(new FutureCallback<CompanyProfielResult>() {
                    @Override
                    public void onCompleted(Exception e, CompanyProfielResult result) {

                        if (result != null) {
                            try {
                                mcompanyProfileView.getCompanyProfileData(result.getData());
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                mcompanyProfileView.Error();
                            }
                        }
                    }
                });


    }
}
