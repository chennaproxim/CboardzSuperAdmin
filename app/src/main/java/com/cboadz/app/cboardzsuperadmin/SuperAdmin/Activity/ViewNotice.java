package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Adapter.NoticeViewConversationAdapter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticeReplyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.Conversation;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.ViewCompanyID;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.ViewNoticeDatum;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.ViewNoticeDTO.ViewNoticeResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.NoticeViewPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.NoticeViewPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.NoticeView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewNotice extends AppCompatActivity implements NoticeView {

    Toolbar toolbar;
    private EditText super_view_notice;
    private TextView mntc_title, ntcview_company, ntcview_date, ntcview_time, ntcview_desc;
    private CircleImageView ntcview_type_icon;
    private String id, token, company_name;
    private ProgressDialog mprogressDialog;
    private SharedPreferences preferences;
    private ViewNoticeDatum viewNoticeDatum;
    private ViewNoticeResult viewNoticeResultDTO;
    private NoticeViewPresenter noticeViewPresenter;
    private RecyclerView conversation_recyclerview;
    private NoticeViewConversationAdapter adapter;
    private ImageView ntcview_reply_btn;
    private int i;
    private List<String> companynames = new ArrayList<String>();
    List<ViewCompanyID> companyIDs = new ArrayList<>();
    private GridView company_list_view;
    final LinearLayoutManager layoutManager = new LinearLayoutManager(ViewNotice.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notice);

        init();

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        mntc_title.setText(bundle.getString("notice_title"));
        if (bundle.getString("notice_type").equals("holiday")) {
            ntcview_type_icon.setImageResource(R.drawable.holiday);
        } else if (bundle.getString("notice_type").equals("teamlunch")) {
            ntcview_type_icon.setImageResource(R.drawable.dinner);
        } else if (bundle.getString("notice_type").equals("problem")) {
            ntcview_type_icon.setImageResource(R.drawable.problem);
        } else if (bundle.getString("notice_type").equals("leave")) {
            ntcview_type_icon.setImageResource(R.drawable.leave);
        } else if (bundle.getString("notice_type").equals("other")) {
            ntcview_type_icon.setImageResource(R.drawable.others);
        } else if (bundle.getString("notice_type").equals("appissue")) {
            ntcview_type_icon.setImageResource(R.drawable.application_issue);
        }

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        token = preferences.getString("tokenkey", String.valueOf(1));
        id = bundle.getString("notice_id");
        id = bundle.getString("notice_id");
        company_name = bundle.getString("notice_company_name");

        viewNoticeResultDTO = new ViewNoticeResult();
        noticeViewPresenter = new NoticeViewPresenterImpl(ViewNotice.this);

        mprogressDialog = new ProgressDialog(ViewNotice.this, R.style.MyAlertDialogStyle);
        mprogressDialog.setMessage(AppConstants.LOADING);
        mprogressDialog.show();
        noticeViewPresenter.sendNoticeId(id, token);

        ntcview_reply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //hiding keyboard when we click button
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                if (TextUtils.isEmpty(super_view_notice.getText().toString())) {
                    super_view_notice.setError("Enter Data");
                    super_view_notice.requestFocus();

                } else {
                    noticeViewPresenter.sendNoticeReply(id, super_view_notice.getText().toString(), token);
                    super_view_notice.setText("");
                }
            }
        });
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.notice_view_toolbar);
        mntc_title = (TextView) findViewById(R.id.ntcview_title);
        ntcview_company = (TextView) findViewById(R.id.ntcview_company);
        ntcview_date = (TextView) findViewById(R.id.ntcview_date);
        ntcview_time = (TextView) findViewById(R.id.ntcview_time);
        ntcview_desc = (TextView) findViewById(R.id.ntcview_desc);
        ntcview_type_icon = (CircleImageView) findViewById(R.id.ntcview_type_icon);
        super_view_notice = (EditText) findViewById(R.id.ntcview_reply);
        conversation_recyclerview = (RecyclerView) findViewById(R.id.view_notice_conversation_recycler_view);
        ntcview_reply_btn = (ImageView) findViewById(R.id.ntcview_reply_btn);
        company_list_view = (GridView) findViewById(R.id.company_list_view);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void Error() {

        mprogressDialog.dismiss();
    }

    @Override
    public void showConveresationView(ArrayList<Conversation> conversations) {

        adapter = new NoticeViewConversationAdapter(conversations, ViewNotice.this);
        mprogressDialog.dismiss();
        conversation_recyclerview.setLayoutManager(layoutManager);
        conversation_recyclerview.setAdapter(adapter);
    }

    @Override
    public void shownNoticeview(final ArrayList<ViewNoticeDatum> viewNoticeData) {

        ntcview_date.setText(viewNoticeData.get(0).getDate());
        ntcview_time.setText(viewNoticeData.get(0).getTime());
        ntcview_desc.setText(viewNoticeData.get(0).getDescription());
//        ntcview_company.setText(viewNoticeData.get(0).getCompanyids().get(0).getCompanyname());
        if (viewNoticeData.get(0).getTitletype().equals("Application")) {
            ntcview_type_icon.setImageResource(R.drawable.application_issue);
        }
        companyIDs = viewNoticeData.get(0).getCompanyids();
        for (i = 0; i < companyIDs.size(); i++) {
            companynames.add(companyIDs.get(i).getCompanyname());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, companynames);
        company_list_view.setAdapter(adapter);
        company_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewNotice.this,CompanyProfile.class);
                intent.putExtra("id",companyIDs.get(position).getId());
                startActivity(intent);
            }
        });
        mprogressDialog.dismiss();

    }

    @Override
    public void shownCompanyData(ArrayList<ViewNoticeDatum> viewNoticeDatumArrayList) {

    }

    @Override
    public void replytoNotice(NoticeReplyDTO noticeReplyDTO) {

        Toast.makeText(this, noticeReplyDTO.getResponse(), Toast.LENGTH_SHORT).show();

    }

}
