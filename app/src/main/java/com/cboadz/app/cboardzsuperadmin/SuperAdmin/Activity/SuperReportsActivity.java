package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity.EmployeesList;
import com.cboadz.app.cboardzsuperadmin.R;

public class SuperReportsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_super);

        toolbar = (Toolbar) findViewById(R.id.super_reports_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.reports_company_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuperReportsActivity.this,CompaniesListActivity.class));
            }
        });
        findViewById(R.id.reports_employees_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuperReportsActivity.this,EmployeesList.class));
            }
        });
        findViewById(R.id.reports_notifications_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuperReportsActivity.this,NoticeBoard.class));
            }
        });
        findViewById(R.id.reports_support_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuperReportsActivity.this,SupportActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
