package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo.NoticesDatum;

import java.util.ArrayList;

/**
 * Created by Proxim on 2/27/2018.
 */

public interface NoticesListView {

    void Error();

    void showresult(ArrayList<NoticesDatum> result);


}
