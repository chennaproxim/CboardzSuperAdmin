package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cboadz.app.cboardzsuperadmin.R;

public class CompanyNoticesActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notices);
        setContentView(R.layout.activity_company_notices);

        toolbar = (Toolbar) findViewById(R.id.company_notice_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.comapny_notice_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyNoticesActivity.this, CompanyViewNotice.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.company_add_notice_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyNoticesActivity.this, CompanyAddNotice.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
