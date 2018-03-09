package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.EditCompanyDTO;

/**
 * Created by Proxim on 3/1/2018.
 */

public interface EditCompanyView {

    void getEditCompanyResponce(EditCompanyDTO editCompanyDTO);

    void errorEditCompany(String responce);
}
