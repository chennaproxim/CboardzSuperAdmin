package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CompanyListView;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;

import java.util.ArrayList;

/**
 * Created by chinn on 02/21/18.
 */

public interface CompanylistAllView {

    void showcompaniesList(ArrayList<CompanyListData> getcompanylist);

    void dataNotfound(String msg);
}
