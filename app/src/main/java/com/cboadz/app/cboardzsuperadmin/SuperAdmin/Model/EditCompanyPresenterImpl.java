package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.EditCompanyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.EditCompanyPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.EditCompanyView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 3/1/2018.
 */

public class EditCompanyPresenterImpl implements EditCompanyPresenter{

    private EditCompanyView meditCompanyView;

    public EditCompanyPresenterImpl(EditCompanyView editCompanyView){

        this.meditCompanyView = editCompanyView;
    }

    @Override
    public void sendeditCompanyData(String id, String companyname, String gst, String companyregno, String companyphoneno, String description, String hrheademail
            , String companyemail, String rootadministratoremail, String yearofestablish, String website, String linke, String industry, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("companyname", companyname);
        json.addProperty("gst", gst);
        json.addProperty("companyregno", companyregno);
        json.addProperty("companyphoneno", companyphoneno);
        json.addProperty("description", description);
        json.addProperty("hrheademail", hrheademail);
        json.addProperty("companyemail", companyemail);
        json.addProperty("rootadministratoremail", rootadministratoremail);
        json.addProperty("yearofestablish", yearofestablish);
        json.addProperty("website", website);
        json.addProperty("linke", linke);
        json.addProperty("industry", industry);
        json.addProperty("token", token);

        Ion.with((Context) meditCompanyView)
                .load(AppConstants.COMPANYEDIT)
                .setJsonObjectBody(json)
                .as(new TypeToken<EditCompanyDTO>() {
                })
                .setCallback(new FutureCallback<EditCompanyDTO>() {
                    @Override
                    public void onCompleted(Exception e, EditCompanyDTO result) {
                        try {

                            meditCompanyView.getEditCompanyResponce(result);

                        }catch (Exception exception) {
                            meditCompanyView.errorEditCompany(result.getResponse());
                            exception.printStackTrace();
                        }
                    }
                });


    }
}
