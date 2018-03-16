package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity.CompanyDashboard;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.LoginDTO.LoginResponce;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.LoginPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.LoginPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.LoginView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.cboadz.app.cboardzsuperadmin.Utils.NetworkCheck;

public class LoginActivity extends Activity implements LoginView {

    private TextInputEditText password, email;
    private LoginPresenter mloginPresenter;
    private ProgressDialog progressDialog;
    private LoginResponce mlogindto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (TextInputEditText) findViewById(R.id.super_admin_email);
        password = (TextInputEditText) findViewById(R.id.super_admin_password);

        email.setText("admin@cboardz.com");
        password.setText("12345");

        mlogindto = new LoginResponce();
        mloginPresenter = new LoginPresenterImpl(LoginActivity.this);

        findViewById(R.id.super_admin_loginbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(LoginActivity.this, R.style.MyAlertDialogStyle);
                String gmail = email.getText().toString().trim();
                String passwrd = password.getText().toString().trim();
                progressDialog.setMessage(AppConstants.LOGING);
                progressDialog.show();
                mloginPresenter.performLogin(gmail, passwrd);

            }
        });
    }

    @Override
    public void loginvalidation() {

        progressDialog.dismiss();
        Toast.makeText(this, AppConstants.LOGINVALIDATION, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isValidUsername() {

        progressDialog.dismiss();
        Toast.makeText(this, AppConstants.VALIDUSERNAME, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void isValidPassword() {
        progressDialog.dismiss();
        Toast.makeText(this, AppConstants.VALIDPASSWORD, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showResponce(LoginResponce loginResponces) {

        progressDialog.dismiss();
        if (loginResponces.getResponse().equals("Login Sucess")) {

            SharedPreferences Preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
            SharedPreferences.Editor editor = Preferences.edit();
            editor.putString("tokenkey", loginResponces.getToken().toString());
            editor.putString("loginid", loginResponces.getData().get(0).getId());
            editor.commit();

            Toast.makeText(this, loginResponces.getResponse(), Toast.LENGTH_SHORT).show();

            if (loginResponces.getLogintype().equals("admin")) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("saname", loginResponces.getData().get(0).getName());
                intent.putExtra("samail", loginResponces.getData().get(0).getEmail());
                intent.putExtra("salogo", loginResponces.getData().get(0).getLogo());
                startActivity(intent);

                //clear Textfields once login success
                clearFileds();

            } else if (loginResponces.getLogintype().equals("company")) {

                SharedPreferences companyPreferenes = getSharedPreferences(AppConstants.COMPANYPROFILEDATA, MODE_PRIVATE);
                SharedPreferences.Editor companyEditor = companyPreferenes.edit();
                companyEditor.putString("companylogo", loginResponces.getData().get(0).getLogo());
                companyEditor.putString("companyname", loginResponces.getData().get(0).getCompanyname());
                companyEditor.putString("companyyoe", loginResponces.getData().get(0).getYearofestablish());
                companyEditor.putString("companygst", loginResponces.getData().get(0).getGst());
                companyEditor.putString("companyreg", loginResponces.getData().get(0).getCompanyregno());
                companyEditor.putString("companyhrheadmail", loginResponces.getData().get(0).getHrheademail());
                companyEditor.putString("companywebsite", loginResponces.getData().get(0).getWebsite());
                companyEditor.putString("companymail", loginResponces.getData().get(0).getCompanyemail());
                companyEditor.putString("companyphone", loginResponces.getData().get(0).getCompanyphoneno());
                companyEditor.putString("companybusinesstype", loginResponces.getData().get(0).getIndustry());
                companyEditor.commit();

                Intent intent = new Intent(LoginActivity.this, CompanyDashboard.class);
                intent.putExtra("mcmpnyname", loginResponces.getData().get(0).getCompanyname());
                intent.putExtra("mcmpnymail", loginResponces.getData().get(0).getCompanyemail());
                intent.putExtra("mcmpnylogo", loginResponces.getData().get(0).getLogo());
                startActivity(intent);

                //clear Textfields once login success
                clearFileds();
            }

        } else {
            Toast.makeText(this, loginResponces.getResponse(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void Error(String responce) {
        progressDialog.dismiss();
        Toast.makeText(this, responce, Toast.LENGTH_SHORT).show();
    }

    //clear Edittext Fields once login success
    private void clearFileds() {
        password.setText("");
        email.setText("");
    }
}
