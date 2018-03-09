package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.Employees.Activity.EmployeeProfile;
import com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.io.InputStream;

public class CompanyDashboard extends AppCompatActivity {

    private ImageView mCompanyLogo;
    private TextView mCompanyName,mCompanyMail;
    private Bitmap bitmap;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.company_main_toolbar);
        setTitle("");
        setSupportActionBar(toolbar);

        mCompanyName = (TextView)findViewById(R.id.dashboard_company_name);
        mCompanyMail = (TextView)findViewById(R.id.dashboard_company_mail);
        mCompanyLogo = (ImageView) findViewById(R.id.dashboard_company_logo);

        progressDialog = new ProgressDialog(CompanyDashboard.this, R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.FETCHING);

        Bundle b = getIntent().getExtras();
        mCompanyName.setText(b.getString("mcmpnyname"));
        mCompanyMail.setText(b.getString("mcmpnymail"));

        progressDialog.show();

        //Download .png or .jpeg
        new GetImageFromUrlCompany(mCompanyLogo).execute(b.getString("mcmpnylogo"));

        findViewById(R.id.employees_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyDashboard.this, EmployeesList.class));
            }
        });
        findViewById(R.id.cmpny_notice_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyDashboard.this, CompanyNoticesActivity.class));
            }
        });
        findViewById(R.id.cmpny_support_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyDashboard.this, CompanySupportActivity.class));
            }
        });
        findViewById(R.id.cmpny_reports).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyDashboard.this, CompanyReportsActivity.class));
            }
        });
        findViewById(R.id.dashboard_company_logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompanyDashboard.this, CompanyProfileActivity.class));
            }
        });
    }

    //Class for download
    public class GetImageFromUrlCompany extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public GetImageFromUrlCompany(ImageView imageview1) {
            this.imageView = imageview1;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urldisplay = strings[0];
            mCompanyLogo = null;
            try {
                InputStream is = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(is);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_company, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.cmpny__logout) {
            AlertUtility.exit(CompanyDashboard.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertUtility.exit(CompanyDashboard.this);
    }
}
