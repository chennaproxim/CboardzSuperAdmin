package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.EditCompanyDTO;

/**
 * Created by Proxim on 3/1/2018.
 */

public interface EditCompanyView {

    void getEditCompanyResponce(EditCompanyDTO editCompanyDTO);

    void errorEditCompany(String responce);
}
