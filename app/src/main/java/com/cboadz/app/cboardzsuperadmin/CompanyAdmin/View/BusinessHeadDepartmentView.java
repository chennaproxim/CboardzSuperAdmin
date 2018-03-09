package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Businessheadlist;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Departmentlist;

import java.util.List;

/**
 * Created by Proxim on 3/7/2018.
 */

public interface BusinessHeadDepartmentView {

    void getBusinessHeadResponce(List<Businessheadlist> businessheadlist);

    void getDeaprtmentResponce(List<Departmentlist> departmentlist);

    void getErrorResponce(String responce);
}
