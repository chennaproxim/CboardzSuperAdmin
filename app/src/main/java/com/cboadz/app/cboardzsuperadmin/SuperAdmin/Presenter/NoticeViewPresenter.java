package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter;

/**
 * Created by Proxim on 2/27/2018.
 */

public interface NoticeViewPresenter {

    void sendNoticeId(String id, String token);

    void sendNoticeReply(String id,String message,String token);
}
