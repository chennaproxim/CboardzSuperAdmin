package com.cboadz.app.cboardzsuperadmin.Employees.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.Employees.DTO.EmployeeProfileResponse;
import com.cboadz.app.cboardzsuperadmin.Employees.Model.EmployeeProfilePresenterImpl;
import com.cboadz.app.cboardzsuperadmin.Employees.Presenter.EmployeeProfilePresenter;
import com.cboadz.app.cboardzsuperadmin.Employees.View.EmployeeProfileView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployeeProfile extends AppCompatActivity implements EmployeeProfileView {

    private String mToken, mLoginId, mEmpId, mEmpPhoneNo, mEmpMailId;
    private SharedPreferences preferences;
    private CircleImageView mEmpPic, mEmpPhone, mEmpMail;
    private TextView mEmpName, mEmpDepartment, mEmpDesignation, mEmployeeId, mEmpCompanyMail, mEmpLastName, mEmpReportingManager, mEmpAddress, mEmpBloodGroup;

    private EmployeeProfilePresenter mEmployeeProfilePresenter;
    private EmployeeProfileResponse mEmployeeProfileResponse;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);

        initialize();

        Toolbar toolbar = (Toolbar) findViewById(R.id.emplye_profile_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        mEmpId = bundle.getString("empid");

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        mToken = preferences.getString("tokenkey", String.valueOf(1));
        mLoginId = preferences.getString("loginid", String.valueOf(1));

        mEmployeeProfileResponse = new EmployeeProfileResponse();
        mEmployeeProfilePresenter = new EmployeeProfilePresenterImpl(EmployeeProfile.this);
        mProgressDialog = new ProgressDialog(EmployeeProfile.this, R.style.MyAlertDialogStyle);
        mProgressDialog.setMessage(AppConstants.FETCHING);
        mProgressDialog.show();
        mEmployeeProfilePresenter.sendEmployeeProfileData(mToken, mEmpId);

        findViewById(R.id.employee_profile_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PhoneNum = mEmpPhoneNo;
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + Uri.encode(PhoneNum.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });

    }

    private void initialize() {

        mEmpPic = (CircleImageView) findViewById(R.id.employee_profile_pic);
        mEmpPhone = (CircleImageView) findViewById(R.id.employee_profile_phone);
        mEmpMail = (CircleImageView) findViewById(R.id.employee_profile_mail);
        mEmpName = (TextView) findViewById(R.id.employee_profile_name);
        mEmpDepartment = (TextView) findViewById(R.id.employee_profile_department);
        mEmpDesignation = (TextView) findViewById(R.id.employee_profile_designation);
        mEmployeeId = (TextView) findViewById(R.id.employee_profile_empid);
        mEmpCompanyMail = (TextView) findViewById(R.id.employee_profile_companymail);
        mEmpLastName = (TextView) findViewById(R.id.employee_profile_lastname);
        mEmpReportingManager = (TextView) findViewById(R.id.employee_profile_reportingmanager);
        mEmpAddress = (TextView) findViewById(R.id.employee_profile_address);
        mEmpBloodGroup = (TextView) findViewById(R.id.employee_profile_bloodgroup);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void showEmployeeProfile(EmployeeProfileResponse employeeResponse) {

        mEmpName.setText(employeeResponse.getData().get(0).getFirstname());
        mEmpDepartment.setText(employeeResponse.getData().get(0).getDepartment());
        mEmpDesignation.setText(employeeResponse.getData().get(0).getDesignation());
        mEmployeeId.setText(employeeResponse.getData().get(0).getEmployeeid());
        mEmpCompanyMail.setText(employeeResponse.getData().get(0).getCompanyemail());
        mEmpLastName.setText(employeeResponse.getData().get(0).getPersonalemail());
        mEmpReportingManager.setText(employeeResponse.getData().get(0).getReportingmanager());
        mEmpAddress.setText(employeeResponse.getData().get(0).getAddress());
        mEmpBloodGroup.setText(employeeResponse.getData().get(0).getBloodgroup());
        mEmpPhoneNo = employeeResponse.getData().get(0).getPhone();
        mEmpMailId = employeeResponse.getData().get(0).getPersonalemail();
        Picasso.with(this).load(employeeResponse.getData().get(0).getProfilephoto()).fit().into(mEmpPic, new Callback() {
            @Override
            public void onSuccess() {
                mProgressDialog.dismiss();
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void onError(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        mProgressDialog.dismiss();

    }
}
