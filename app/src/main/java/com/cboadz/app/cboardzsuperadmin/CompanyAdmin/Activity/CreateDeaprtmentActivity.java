package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateDepartmentDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model.CreateDepartmentPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateDepartmentPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateDepartmentView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

public class CreateDeaprtmentActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,CreateDepartmentView{


    private Spinner mTypespinner;
    String mSpinner_type;
    private String mToken, mCompanyId;
    private SharedPreferences preferences;
    private EditText department_name,department_emp_id,department_person_name,department_mail,department_phone_no;
    private String deptname,deptempid,deptpersonname,deptemail,deptphoneno;

    private CreateDepartmentPresenter mCreateDepartmentPresenter;
    private CreateDepartmentDTO mCreateDepartmentDTO;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deaprtment);

        Toolbar toolbar = (Toolbar) findViewById(R.id.departments_toolbar);
        department_name = (EditText) findViewById(R.id.company_department_name);
        department_emp_id = (EditText) findViewById(R.id.company_emp_id);
        department_person_name = (EditText) findViewById(R.id.company_department_person_name);
        department_mail = (EditText) findViewById(R.id.company_department_mail);
        department_phone_no = (EditText) findViewById(R.id.company_department_phone_no);
        mTypespinner = (Spinner) findViewById(R.id.report_to_spinner);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        mToken = preferences.getString("tokenkey", String.valueOf(1));
        mCompanyId = preferences.getString("loginid", String.valueOf(1));

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mCreateDepartmentDTO = new CreateDepartmentDTO();
        mCreateDepartmentPresenter = new CreateDepartmentPresenterImpl(CreateDeaprtmentActivity.this);
        mProgressDialog = new ProgressDialog(this, R.style.MyAlertDialogStyle);
        mProgressDialog.setMessage(AppConstants.LOADING);

        findViewById(R.id.department_submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deptname = department_name.getText().toString();
                deptempid = department_emp_id.getText().toString();
                deptpersonname = department_person_name.getText().toString();
                deptemail = department_mail.getText().toString();
                deptphoneno = department_phone_no.getText().toString();

                if (TextUtils.isEmpty(deptname)) {
                    department_name.requestFocus();
                    department_name.setError("Enter data");
                } else if (TextUtils.isEmpty(deptempid)) {
                    department_emp_id.requestFocus();
                    department_emp_id.setError("Enter data");
                } else if (TextUtils.isEmpty(deptpersonname)) {
                    department_person_name.requestFocus();
                    department_person_name.setError("Enter data");
                } else if (TextUtils.isEmpty(deptemail)) {
                    department_mail.requestFocus();
                    department_mail.setError("Enter data");
                } else if (TextUtils.isEmpty(deptphoneno)) {
                    department_phone_no.requestFocus();
                    department_phone_no.setError("Enter data");
                } else {
                    mProgressDialog.show();
                    mCreateDepartmentPresenter.createDepartment(deptname,deptempid,deptpersonname,deptemail,deptphoneno
                    ,mSpinner_type,mToken,mCompanyId);
                }

            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        mSpinner_type = (parent.getSelectedItem()).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void showCreateDepartmentResponce(CreateDepartmentDTO createDepartmentDTO) {
        mProgressDialog.dismiss();
        if (createDepartmentDTO.getRes().equals("false")){
            Toast.makeText(this, createDepartmentDTO.getResponse(), Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, createDepartmentDTO.getResponse(), Toast.LENGTH_SHORT).show();
            CreateDeaprtmentActivity.this.finish();
        }
    }

    @Override
    public void onError(String msg) {
        mProgressDialog.dismiss();
    }
}
