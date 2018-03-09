package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateBusinessHeadDTO;

/**
 * Created by Proxim on 3/6/2018.
 */

public interface CreateBusinessHeadView {

    void showCreteBusinessHeadResponse(CreateBusinessHeadDTO createBusinessHeadDTO);

    void onError(String msg);
}
