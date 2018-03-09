package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CreateNoticeDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CreateNoticePresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CreateNoticeView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Proxim on 2/28/2018.
 */

public class CreateNoticePresenterImpl implements CreateNoticePresenter {

    private CreateNoticeView mcreateNoticeView;

    public CreateNoticePresenterImpl(CreateNoticeView createNoticeView) {

        this.mcreateNoticeView = createNoticeView;
    }

    @Override
    public void addNotice(String title, String titletype, String description, String companyid, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("title", title);
        json.addProperty("titletype", titletype);
        json.addProperty("description", description);
        json.addProperty("companyids", companyid);
        json.addProperty("token", token);

        Ion.with((Context) mcreateNoticeView)
                .load(AppConstants.ADDNOTICE)
                .setJsonObjectBody(json)
                .as(new TypeToken<CreateNoticeDTO>() {
                })
                .setCallback(new FutureCallback<CreateNoticeDTO>() {
                    @Override
                    public void onCompleted(Exception e, CreateNoticeDTO result) {
                        if (result != null) {
                            try {
                                mcreateNoticeView.addNoticeResponce(result);

                            } catch (Exception exception) {
                                mcreateNoticeView.Error();
                                exception.printStackTrace();
                            }
                        }
                        else mcreateNoticeView.Error();
                    }
                });

    }
}
