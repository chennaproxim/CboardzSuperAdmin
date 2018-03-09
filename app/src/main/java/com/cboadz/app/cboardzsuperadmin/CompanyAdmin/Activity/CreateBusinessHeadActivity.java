package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateBusinessHeadDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model.CreateBusinessHeadPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateBusinessHeadPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateBusinessHeadView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import static com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility.isValidEmail;

public class CreateBusinessHeadActivity extends AppCompatActivity implements CreateBusinessHeadView{

    private EditText business_head_name,business_head_mail,business_head_phone;
    private String headname,heademail,headphone;
    private String mToken, mCompanyId;
    private SharedPreferences preferences;

    private CreateBusinessHeadDTO mCreateBusinessHeadDTO;
    private CreateBusinessHeadPresenter mCreateBusinessHeadPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_head);

        Toolbar toolbar = (Toolbar) findViewById(R.id.business_head_toolbar);
        business_head_name = (EditText) findViewById(R.id.company_business_head_name);
        business_head_mail = (EditText) findViewById(R.id.company_business_head_mail);
        business_head_phone = (EditText) findViewById(R.id.company_business_head_phone);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        mToken = preferences.getString("tokenkey", String.valueOf(1));
        mCompanyId = preferences.getString("loginid", String.valueOf(1));

        mCreateBusinessHeadDTO = new CreateBusinessHeadDTO();
        mCreateBusinessHeadPresenter = new CreateBusinessHeadPresenterImpl(CreateBusinessHeadActivity.this);
        mProgressDialog = new ProgressDialog(this, R.style.MyAlertDialogStyle);
        mProgressDialog.setMessage(AppConstants.LOADING);

        findViewById(R.id.business_head_create_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headname = business_head_name.getText().toString();
                heademail = business_head_mail.getText().toString();
                headphone = business_head_phone.getText().toString();


                if (TextUtils.isEmpty(headname)) {
                    business_head_name.requestFocus();
                    business_head_name.setError("Enter data");
                } else if (!isValidEmail(heademail)) {
                    business_head_mail.requestFocus();
                    business_head_mail.setError("Enter Valid Email");
                } else if (TextUtils.isEmpty(headphone)) {
                    business_head_phone.requestFocus();
                    business_head_phone.setError("Enter data");
                } else {
                    mProgressDialog.show();
                    mCreateBusinessHeadPresenter.sendCreateBusinessHeadParamaters(headname,heademail
                            ,mToken,headphone,mCompanyId);
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
    public void showCreteBusinessHeadResponse(CreateBusinessHeadDTO createBusinessHeadDTO) {
        mProgressDialog.dismiss();
        if (createBusinessHeadDTO.getRes().equals("false")){
            Toast.makeText(this, createBusinessHeadDTO.getResponse() , Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, createBusinessHeadDTO.getResponse(), Toast.LENGTH_SHORT).show();
            CreateBusinessHeadActivity.this.finish();
        }
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        mProgressDialog.dismiss();
    }
}
