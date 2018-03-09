package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateBusinessHeadDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateDepartmentDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateBusinessHeadPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateBusinessHeadView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/6/2018.
 */

public class CreateBusinessHeadPresenterImpl implements CreateBusinessHeadPresenter {

    private CreateBusinessHeadView mCreateBusinessHeadView;

    public CreateBusinessHeadPresenterImpl(CreateBusinessHeadView createBusinessHeadView){

        this.mCreateBusinessHeadView = createBusinessHeadView;
    }

    @Override
    public void sendCreateBusinessHeadParamaters(String businessheadname, String mail, String token
            , String phonenumber, String companyid) {

        JsonObject json = new JsonObject();
        json.addProperty("businessheadname", businessheadname);
        json.addProperty("mail", mail);
        json.addProperty("token", token);
        json.addProperty("phonenumber", phonenumber);
        json.addProperty("companyid", companyid);

        Ion.with((Context) mCreateBusinessHeadView)
                .load(AppConstants.CREATEDEPARTMENT)
                .setJsonObjectBody(json)
                .as(new TypeToken<CreateBusinessHeadDTO>() {
                })
                .setCallback(new FutureCallback<CreateBusinessHeadDTO>() {
                    @Override
                    public void onCompleted(Exception e, CreateBusinessHeadDTO result) {
                        if (result != null) {
                            try {
                                mCreateBusinessHeadView.showCreteBusinessHeadResponse(result);

                            } catch (Exception ex) {
                                mCreateBusinessHeadView.onError(result.getResponse());
                                ex.printStackTrace();
                            }
                        }

                    }
                });

    }
}
