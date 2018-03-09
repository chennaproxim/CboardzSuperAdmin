package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.EditCompanyDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.EditCompanyPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.EditCompanyPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.EditCompanyView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditCompany extends AppCompatActivity implements EditCompanyView {

    private Toolbar toolbar;
    public ImageView mcmpnycoverimage;
    private CircleImageView mcmpnyprfilelogo;
    private EditText mid, mCompanyname, mYearofestablish, mRegno, mGst, mrootemail, mWebsite, mCompanyemail, mPhoneno,
            mBusinesstype, mlinke, mdesc, mhrhead;
    private String msid, msCompanyname, msYearofestablish, msRegno, msGst, msrootemail, msWebsite, msCompanyemail, msPhoneno,
            msBusinesstype, mslinke, msdesc, mshrhead,mslogo,mscoverphoto;
    private SharedPreferences preferences;
    private String token;
    private Bundle bundle;
    private String cmpnyimage, coverimage, id;
    private Button mEditcompany;
    private Bitmap bitmap;

    private ProgressDialog progressDialog;
    private EditCompanyPresenter editCompanyPresenter;
    private EditCompanyDTO editCompanyDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_company);

        init();

        bundle = getIntent().getExtras();
        msid = bundle.getString("ceid");
        msCompanyname = bundle.getString("cecompanyname");
        msYearofestablish = bundle.getString("ceyoe");
        msRegno = bundle.getString("ceregno");
        msGst = bundle.getString("cegst");
        msrootemail = bundle.getString("ceroot");
        msWebsite = bundle.getString("cewebsite");
        msCompanyemail = bundle.getString("cecmpnemial");
        msPhoneno = bundle.getString("cephoneno");
        msBusinesstype = bundle.getString("ceindustry");
        mslinke = bundle.getString("celink");
        msdesc = bundle.getString("cedesc");
        mshrhead = bundle.getString("cehrhead");
        mslogo = bundle.getString("celogo");
        mscoverphoto = bundle.getString("cecover");

        if (mscoverphoto.equals("")) {
            mcmpnycoverimage.setImageResource(R.drawable.profile_bg);

        } else {
            Picasso.with(this).load(mscoverphoto).into(mcmpnycoverimage);
        }
        if (mslogo.equals("")) {

            mcmpnyprfilelogo.setImageResource(R.drawable.profile_icon);

        } else {
            //Download .png or .jpeg
            new GetImageFromUrlEditCompany(mcmpnyprfilelogo).execute(mslogo);
        }

        setData();

        toolbar = (Toolbar) findViewById(R.id.compny_prfle_edit_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        token = preferences.getString("tokenkey", String.valueOf(1));

        editCompanyDTO = new EditCompanyDTO();
        editCompanyPresenter = new EditCompanyPresenterImpl(EditCompany.this);
        progressDialog = new ProgressDialog(EditCompany.this, R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.UPDATING);

        mEditcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.show();
                if (TextUtils.isEmpty(mCompanyname.getText().toString())) {
                    mCompanyname.requestFocus();
                    mCompanyname.setError("Enter data");
                } else if (TextUtils.isEmpty(mYearofestablish.getText().toString())) {
                    mYearofestablish.requestFocus();
                    mYearofestablish.setError("Enter data");
                } else if (TextUtils.isEmpty(mRegno.getText().toString())) {
                    mRegno.requestFocus();
                    mRegno.setError("Enter data");
                } else if (TextUtils.isEmpty(mGst.getText().toString())) {
                    mGst.requestFocus();
                    mGst.setError("Enter data");
                } else if (TextUtils.isEmpty(mrootemail.getText().toString())) {
                    mrootemail.requestFocus();
                    mrootemail.setError("Enter data");
                } else if (TextUtils.isEmpty(mWebsite.getText().toString())) {
                    mWebsite.requestFocus();
                    mWebsite.setError("Enter data");
                } else if (TextUtils.isEmpty(mCompanyemail.getText().toString())) {
                    mCompanyemail.requestFocus();
                    mCompanyemail.setError("Enter data");
                } else if (TextUtils.isEmpty(mPhoneno.getText().toString())) {
                    mPhoneno.requestFocus();
                    mPhoneno.setError("Enter data");
                } else if (TextUtils.isEmpty(mBusinesstype.getText().toString())) {
                    mBusinesstype.requestFocus();
                    mBusinesstype.setError("Enter data");
                } else if (TextUtils.isEmpty(mlinke.getText().toString())) {
                    mlinke.requestFocus();
                    mlinke.setError("Enter data");
                } else if (TextUtils.isEmpty(mlinke.getText().toString())) {
                    mlinke.requestFocus();
                    mlinke.setError("Enter data");
                } else if (TextUtils.isEmpty(mhrhead.getText().toString())) {
                    mdesc.requestFocus();
                    mdesc.setError("Enter data");
                } else {
                    editCompanyPresenter.sendeditCompanyData(msid, mCompanyname.getText().toString(), mGst.getText().toString(), mRegno.getText().toString()
                            , mPhoneno.getText().toString(), mdesc.getText().toString(), mhrhead.getText().toString()
                            , mCompanyemail.getText().toString(), mrootemail.getText().toString(), mYearofestablish.getText().toString()
                            , mWebsite.getText().toString(), mlinke.getText().toString(), mBusinesstype.getText().toString(), token);
                }
            }
        });

    }

    private void setData() {

        mCompanyname.setText(msCompanyname);
        mYearofestablish.setText(msYearofestablish);
        mRegno.setText(msRegno);
        mGst.setText(msGst);
        mrootemail.setText(msrootemail);
        mWebsite.setText(msWebsite);
        mCompanyemail.setText(msCompanyemail);
        mPhoneno.setText(msPhoneno);
        mBusinesstype.setText(msBusinesstype);
        mlinke.setText(mslinke);
        mdesc.setText(msdesc);
        mhrhead.setText(mshrhead);

    }

    private void init() {

        mcmpnyprfilelogo = (CircleImageView) findViewById(R.id.companyedit_pfle_logo);
        mcmpnycoverimage = (ImageView) findViewById(R.id.companyedit_cover_image);
        mCompanyname = (EditText) findViewById(R.id.cpcompanyedit_name);
        mYearofestablish = (EditText) findViewById(R.id.cpcompanyedit_yoe);
        mRegno = (EditText) findViewById(R.id.cpcompanyedit_regno);
        mGst = (EditText) findViewById(R.id.cpcompanyedit_gst);
        mrootemail = (EditText) findViewById(R.id.cpcompanyedit_root);
        mWebsite = (EditText) findViewById(R.id.cpcompanyedit_website);
        mCompanyemail = (EditText) findViewById(R.id.cpcompanyedit_cemail);
        mPhoneno = (EditText) findViewById(R.id.cpcompanyedit_cphoneno);
        mBusinesstype = (EditText) findViewById(R.id.cpcompanyedit_business_type);
        mlinke = (EditText) findViewById(R.id.cpcompanyedit_linke);
        mdesc = (EditText) findViewById(R.id.cpcompanyedit_desc);
        mEditcompany = (Button) findViewById(R.id.edit_cmpny_btn);
        mhrhead = (EditText) findViewById(R.id.cpcompanyedit_hrhead);
    }

    //Class for download
    public class GetImageFromUrlEditCompany extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public GetImageFromUrlEditCompany(ImageView imageview1) {
            this.imageView = imageview1;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urldisplay = strings[0];
            mcmpnyprfilelogo = null;
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
        }
    }

    @Override
    public void getEditCompanyResponce(EditCompanyDTO editCompanyDTO) {

        progressDialog.dismiss();
        Toast.makeText(this, editCompanyDTO.getResponse(), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditCompany.this,CompaniesListActivity.class));

    }

    @Override
    public void errorEditCompany(String responce) {

        progressDialog.dismiss();
        Toast.makeText(this, responce, Toast.LENGTH_SHORT).show();
    }

}
