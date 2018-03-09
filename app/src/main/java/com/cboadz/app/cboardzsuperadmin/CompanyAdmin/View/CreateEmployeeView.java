package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateEmployeeDTO;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface CreateEmployeeView {

    void showEmployeeCreatedStatus(CreateEmployeeDTO createEmployeeDTO);

    void onError(String msg);
}
