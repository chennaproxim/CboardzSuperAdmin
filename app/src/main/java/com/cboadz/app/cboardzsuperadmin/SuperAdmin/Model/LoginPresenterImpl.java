package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model;

import android.content.Context;
import android.text.TextUtils;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.LoginDTO.LoginResponce;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.LoginPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.LoginView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by chinn on 02/21/18.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mloginView;

    public LoginPresenterImpl(LoginView loginView) {

        this.mloginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {

            mloginView.loginvalidation();

        }else {
            if (AlertUtility.isValidEmail(username)) {

                if (AlertUtility.isValidPassword(password)) {

                    JsonObject json = new JsonObject();
                    json.addProperty("email", username);
                    json.addProperty("password", password);

                    Ion.with((Context) mloginView)
                            .load(AppConstants.ADMIN_LOGIN_URL)
                            .setJsonObjectBody(json)
                            .as(new TypeToken<LoginResponce>() {
                            })
                            .setCallback(new FutureCallback<LoginResponce>() {
                                @Override
                                public void onCompleted(Exception e, LoginResponce result) {
                                try {
                                    mloginView.showResponse(result);

                                }catch (Exception exception) {
                                    mloginView.Error(result.getResponse());
                                    exception.printStackTrace();
                                }
                                }
                            });
                } else {
                    mloginView.isValidPassword();
                }
            } else {
                mloginView.isValidUsername();
            }
        }

    }
}
