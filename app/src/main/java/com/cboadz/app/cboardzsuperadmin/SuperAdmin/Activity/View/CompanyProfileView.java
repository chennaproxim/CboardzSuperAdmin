package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.CompanyProfileDTO.ProfileData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Proxim on 3/1/2018.
 */

public interface CompanyProfileView {

    void getCompanyProfileData(List<ProfileData> profileDatas);

    void Error();

}
