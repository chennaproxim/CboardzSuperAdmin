package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CompanyListModel;

import android.support.v4.app.Fragment;
import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanylistResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CompanyListPresenter.CompanylistAllPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CompanyListView.CompanylistAllView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinn on 02/21/18.
 */

public class CompanylistAllPresenterImpl implements CompanylistAllPresenter {

    private CompanylistAllView mcompanylistAllView;

    public CompanylistAllPresenterImpl(CompanylistAllView companylistAllView){

        this.mcompanylistAllView = companylistAllView;

    }

    @Override
    public void getAllCompanylist(String token) {

        Ion.with((Fragment) mcompanylistAllView)
                .load(AppConstants.COMPANYALLLIST)
                .setBodyParameter("token",token)
                .as(new TypeToken<CompanylistResult>() {
                })
                .setCallback(new FutureCallback<CompanylistResult>() {
                    @Override
                    public void onCompleted(Exception e, CompanylistResult result) {
                        try {
                            if (result != null) {
                                mcompanylistAllView.showcompaniesList((ArrayList<CompanyListData>) result.getData());
                            }else {
                                mcompanylistAllView.dataNotfound("No records found");
                            }

                        }catch (Exception exception){
                            exception.printStackTrace();
//                            mcompanylistAllView.dataNotfound("No records found");
                        }
                    }
                });

    }
}
