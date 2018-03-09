package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.CreateCompanyResultDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Presenter.CreateCompanyPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View.CreateCompanyView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;

import java.io.File;

/**
 * Created by chinn on 02/21/18.
 */

public class CreateCompanyPresenterImpl implements CreateCompanyPresenter {

    private CreateCompanyView mcreateCompanyView;

    public CreateCompanyPresenterImpl(CreateCompanyView createCompanyView) {

        this.mcreateCompanyView = createCompanyView;
    }

    @Override
    public void sendComapnyData(String companyname, String gst, String companyregno, String companyphoneno, String description,
                                String hrheademail, String companyemail, String rootadministratoremail, String yearofestablish,
                                String website, String linke, String industry, String password, String token,
                                File logo, File coverimage) {

        Ion.with((Context) mcreateCompanyView)
                .load(AppConstants.CREATECOMPANY)
                .uploadProgress(new ProgressCallback() {
                    @Override
                    public void onProgress(long downloaded, long total) {

                    }
                })
                .setMultipartParameter("companyname", companyname)
                .setMultipartParameter("gst", gst)
                .setMultipartParameter("companyregno", companyregno)
                .setMultipartParameter("companyphoneno", companyphoneno)
                .setMultipartParameter("description", description)
                .setMultipartParameter("hrheademail", hrheademail)
                .setMultipartParameter("companyemail", companyemail)
                .setMultipartParameter("rootadministratoremail", rootadministratoremail)
                .setMultipartParameter("yearofestablish", yearofestablish)
                .setMultipartParameter("website", website)
                .setMultipartParameter("linke", linke)
                .setMultipartParameter("industry", industry)
                .setMultipartParameter("password", password)
                .setMultipartParameter("token", token)
                .setMultipartFile("logo", "image/jpeg", logo)
                .setMultipartFile("coverimage", "image/jpeg", logo)
                .as(new TypeToken<CreateCompanyResultDTO>() {
                })
                .setCallback(new FutureCallback<CreateCompanyResultDTO>() {
                    @Override
                    public void onCompleted(Exception e, CreateCompanyResultDTO result) {
                        try {
                            String res = result.toString();
                            mcreateCompanyView.uploadResult(result);
                            mcreateCompanyView.clearFields();

                        }catch (Exception exception){
                            mcreateCompanyView.Error();
                            exception.printStackTrace();
                        }

                    }
                });
    }
}