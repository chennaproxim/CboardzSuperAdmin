package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.NoticeReplyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.NoticesListDTo.Companyid;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.Conversation;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.ViewCompanyID;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.ViewNoticeDatum;

import java.util.ArrayList;

/**
 * Created by Proxim on 2/27/2018.
 */

public interface NoticeView {

    void Error();

    void showConveresationView(ArrayList<Conversation> conversations);

    void shownNoticeview(ArrayList<ViewNoticeDatum> viewNoticeData);

    void shownCompanyData(ArrayList<ViewNoticeDatum> viewNoticeDatumArrayList);

    void replytoNotice(NoticeReplyDTO noticeReplyDTO);
}
