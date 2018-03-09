package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyProfileDTO.ProfileData;

import java.util.List;

/**
 * Created by Proxim on 3/1/2018.
 */

public interface CompanyProfileView {

    void getCompanyProfileData(List<ProfileData> profileDatas);

    void Error();

}
