package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model;


import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.BusinessHeadDepartmentListDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateBusinessHeadDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.BusinessHeadDepartmentPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.BusinessHeadDepartmentView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/7/2018.
 */

public class BusinessHeadDepartmentPresenterImpl implements BusinessHeadDepartmentPresenter{

    private BusinessHeadDepartmentView mBusinessHeadDepartmentView;

    public BusinessHeadDepartmentPresenterImpl(BusinessHeadDepartmentView businessHeadDepartmentView){

        this.mBusinessHeadDepartmentView = businessHeadDepartmentView;
    }


    @Override
    public void sendBusinessHeadDepartmentId(String companyId, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("companyid", companyId);
        json.addProperty("token", token);

        Ion.with((Context) mBusinessHeadDepartmentView)
                .load(AppConstants.BUSINESSDEPARTMENTLIST)
                .setJsonObjectBody(json)
                .as(new TypeToken<BusinessHeadDepartmentListDTO>() {
                })
                .setCallback(new FutureCallback<BusinessHeadDepartmentListDTO>() {
                    @Override
                    public void onCompleted(Exception e, BusinessHeadDepartmentListDTO result) {
                        if (result != null) {
                            try {

                                mBusinessHeadDepartmentView.getBusinessHeadResponce(result.getBusinessheadlist());
                                mBusinessHeadDepartmentView.getDeaprtmentResponce(result.getDepartmentlist());

                            } catch (Exception ex) {
                                mBusinessHeadDepartmentView.getErrorResponce(result.getResponse());
                                ex.printStackTrace();
                            }
                        }

                    }
                });

    }
}
