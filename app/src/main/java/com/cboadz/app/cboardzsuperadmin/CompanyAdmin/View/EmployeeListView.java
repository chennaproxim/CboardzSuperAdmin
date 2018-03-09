package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View;


import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeData;

import java.util.List;

/**
 * Created by Proxim on 3/5/2018.
 */

public interface EmployeeListView {

    void showEmployeesList(List<EmployeeData> getEmployeeData);

    void onError(String msg);
}
