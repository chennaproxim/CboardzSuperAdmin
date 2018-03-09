package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Adapter.NoticesListAdapter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo.NoticesDatum;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo.NoticesResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.NoticesListPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.NoticesListPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.NoticesListView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;

public class NoticeBoard extends AppCompatActivity implements NoticesListView{

    private Toolbar toolbar;
    private RecyclerView notices_recyclerView;
    private NoticesListPresenter mnoticesListPresenter;
    private NoticesResult mnoticesListDTO;
    private ProgressDialog mprogressDialog;
    private SharedPreferences preferences;
    private NoticesListAdapter adapter;
    private String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        toolbar = (Toolbar) findViewById(R.id.notice_toolbar);
        notices_recyclerView = (RecyclerView) findViewById(R.id.all_notices_recycler_view);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        token = preferences.getString("tokenkey", String.valueOf(1));

        mnoticesListDTO = new NoticesResult();
        mnoticesListPresenter = new NoticesListPresenterImpl(NoticeBoard.this);

        mprogressDialog = new ProgressDialog(NoticeBoard.this, R.style.MyAlertDialogStyle);
        mprogressDialog.setMessage(AppConstants.LOADING);
        mprogressDialog.show();
        mnoticesListPresenter.sendNoticesToken(token);

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_notice_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoticeBoard.this, AddNotice.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void Error() {

    }

    @Override
    public void showresult(ArrayList<NoticesDatum> result) {

        adapter = new NoticesListAdapter(result,NoticeBoard.this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(NoticeBoard.this);
        mprogressDialog.dismiss();
        notices_recyclerView.setLayoutManager(layoutManager);
        notices_recyclerView.setAdapter(adapter);

    }


}
