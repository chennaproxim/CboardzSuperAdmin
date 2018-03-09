package com.cboadz.app.cboardzsuperadmin.Employees.View;

import com.cboadz.app.cboardzsuperadmin.Employees.DTO.EmployeeProfileResponse;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface EmployeeProfileView {

    void showEmployeeProfile(EmployeeProfileResponse employeeResponse);

    void onError(String msg);
}
