package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Model;

import android.content.Context;

import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.NoticeReplyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.Conversation;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.ViewNoticeDatum;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.ViewNoticeResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Presenter.NoticeViewPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.View.NoticeView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by Proxim on 2/27/2018.
 */

public class NoticeViewPresenterImpl implements NoticeViewPresenter {

    private NoticeView mnoticesView;

    public NoticeViewPresenterImpl(NoticeView noticesView) {
        this.mnoticesView = noticesView;
    }

    @Override
    public void sendNoticeId(String id, String token) {

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("token", token);

        Ion.with((Context) mnoticesView)
                .load(AppConstants.VIEWNOTICE)
                .setJsonObjectBody(json)
                .as(new TypeToken<ViewNoticeResult>() {
                })
                .setCallback(new FutureCallback<ViewNoticeResult>() {
                    @Override
                    public void onCompleted(Exception e, ViewNoticeResult result) {
                        try {

                            if ((ArrayList<Conversation>) result.getConversations() != null) {
                                mnoticesView.showConveresationView((ArrayList<Conversation>) result.getConversations());
                            }
                            if ((ArrayList<ViewNoticeDatum>) result.getData() != null) {
                                mnoticesView.shownNoticeview((ArrayList<ViewNoticeDatum>) result.getData());
                            }

                        } catch (Exception exception) {
                            mnoticesView.Error();
                            exception.printStackTrace();
                        }
                    }
                });

    }

    @Override
    public void sendNoticeReply(String id, String message, String token) {

        JsonObject jsonreply = new JsonObject();
        jsonreply.addProperty("noticeid", id);
        jsonreply.addProperty("token", token);
        jsonreply.addProperty("message", message);


        Ion.with((Context) mnoticesView)
                .load(AppConstants.NOTICEREPLY)
                .setJsonObjectBody(jsonreply)
                .as(new TypeToken<NoticeReplyDTO>() {
                })
                .setCallback(new FutureCallback<NoticeReplyDTO>() {
                    @Override
                    public void onCompleted(Exception e, NoticeReplyDTO result) {

                        if (result != null){
                            try {
                                mnoticesView.replytoNotice(result);

                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                });

    }
}
