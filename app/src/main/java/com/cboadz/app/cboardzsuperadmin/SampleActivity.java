package com.cboadz.app.cboardzsuperadmin;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity.CompanyDashboard;
import com.cboadz.app.cboardzsuperadmin.Employees.Activity.EmployeeDashboard;
import com.cboadz.app.cboardzsuperadmin.Utils.AbsRuntimePermission;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity.LoginActivity;

public class SampleActivity extends AbsRuntimePermission {


    private static final int REQUEST_PERMISSION = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        requestAppPermissions(new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                },
                R.string.msg, REQUEST_PERMISSION);

        findViewById(R.id.main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SampleActivity.this, LoginActivity.class));
            }
        });
        findViewById(R.id.company_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SampleActivity.this, CompanyDashboard.class));
            }
        });
        findViewById(R.id.employee_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SampleActivity.this, EmployeeDashboard.class));
            }
        });
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
