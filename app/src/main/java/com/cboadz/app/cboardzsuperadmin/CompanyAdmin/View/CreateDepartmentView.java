package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateDepartmentDTO;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface CreateDepartmentView {

    void showCreateDepartmentResponce(CreateDepartmentDTO createDepartmentDTO);

    void onError(String msg);
}
