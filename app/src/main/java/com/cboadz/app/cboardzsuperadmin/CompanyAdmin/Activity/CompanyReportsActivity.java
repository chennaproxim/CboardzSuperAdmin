package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cboadz.app.cboardzsuperadmin.R;

public class CompanyReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_reports);

        Toolbar toolbar = (Toolbar) findViewById(R.id.company_reports_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        findViewById(R.id.cmpny_reports_employees_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyReportsActivity.this,EmployeesList.class));
            }
        });
        findViewById(R.id.cmpny_reports_notifications_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyReportsActivity.this,CompanyNoticesActivity.class));
            }
        });
        findViewById(R.id.cmpny_reports_support_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyReportsActivity.this,CompanySupportActivity.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
