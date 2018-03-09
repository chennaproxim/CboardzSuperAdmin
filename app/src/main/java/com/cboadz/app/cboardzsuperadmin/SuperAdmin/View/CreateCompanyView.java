package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CreateCompanyResultDTO;

/**
 * Created by chinn on 02/21/18.
 */

public interface CreateCompanyView {

    void clearFields();

    void Error();

    void uploadResult(CreateCompanyResultDTO createCompanyResultDTO);

}
