package com.cboadz.app.cboardzsuperadmin.SuperAdmin.View;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticeReplyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.Conversation;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.ViewNoticeDatum;

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
