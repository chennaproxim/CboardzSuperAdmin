package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.NoticesListDTo.NoticesDatum;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.NoticesListDTo.NoticesResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Presenter.NoticesListPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View.NoticesListView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Proxim on 2/27/2018.
 */

public class NoticesListPresenterImpl implements NoticesListPresenter{

    private NoticesListView mnoticesListView;

    public NoticesListPresenterImpl(NoticesListView noticesListView){
        this.mnoticesListView = noticesListView;
    }

    @Override
    public void sendNoticesToken(String token) {

        JsonObject json = new JsonObject();
        json.addProperty("token", token);

        Ion.with((Context) mnoticesListView)
                .load(AppConstants.NOTICESLIST)
                .setJsonObjectBody(json)
                .as(new TypeToken<NoticesResult>() {
                })
                .setCallback(new FutureCallback<NoticesResult>() {
                    @Override
                    public void onCompleted(Exception e, NoticesResult result) {
                        try {
                            mnoticesListView.showresult((ArrayList<NoticesDatum>) result.getData());

                        }catch (Exception exception) {
                            mnoticesListView.Error();
                            exception.printStackTrace();
                        }
                    }
                });

    }
}
