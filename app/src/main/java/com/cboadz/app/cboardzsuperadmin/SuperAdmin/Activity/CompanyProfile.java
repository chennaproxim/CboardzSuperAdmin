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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyProfileDTO.CompanyProfielResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyProfileDTO.ProfileData;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CompanyProfilePresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CompanyProfilePresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CompanyProfileView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompanyProfile extends AppCompatActivity implements CompanyProfileView{

    private Toolbar toolbar;
    public ImageView mcmpnycoverimage;
    private ImageView mcmpnyprofilelogo;
    private Bundle bundle;
    private String cmpnyimage, coverimage,id,token;
    private Bitmap bitmap;
    private TextView mCompanyname, mYearofestablish, mRegno, mGst, mHremail, mWebsite, mCompanyemail, mPhoneno, mBusinesstype;
    private String sid,scompanyname,sgst,sregno,sphoneno,sdesc,shrheadmail,scompanymail,srootmail,syoe,swebsite,slink
            ,sindustry,slogo,scoverlogo;

    private ProgressDialog dialog;
    private CompanyProfilePresenter companyProfilePresenter;
    private CompanyProfielResult companyProfielResult;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);

        init();
        toolbar = (Toolbar) findViewById(R.id.compny_prfle_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //get tokent from login page
        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        String token = preferences.getString("tokenkey", String.valueOf(0));

        //get Id form Companies mList
        bundle = getIntent().getExtras();
        id = bundle.getString("id");

        dialog = new ProgressDialog(CompanyProfile.this, R.style.MyAlertDialogStyle);
        dialog.setMessage(AppConstants.FETCHING);
        dialog.show();
        companyProfielResult = new CompanyProfielResult();
        companyProfilePresenter = new CompanyProfilePresenterImpl(CompanyProfile.this);
        companyProfilePresenter.sendCompanyId(id,token);

        findViewById(R.id.edit_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CompanyProfile.this,EditCompany.class);
                intent.putExtra("ceid", sid);
                intent.putExtra("cecompanyname",scompanyname );
                intent.putExtra("cegst", sgst);
                intent.putExtra("ceregno", sregno);
                intent.putExtra("cephoneno", sphoneno);
                intent.putExtra("cedesc", sdesc);
                intent.putExtra("cehrhead",shrheadmail );
                intent.putExtra("cecmpnemial", scompanymail);
                intent.putExtra("ceroot", srootmail);
                intent.putExtra("ceyoe", syoe);
                intent.putExtra("cewebsite", swebsite);
                intent.putExtra("celink", slink);
                intent.putExtra("ceindustry", sindustry);
                intent.putExtra("celogo", slogo);
                intent.putExtra("cecover", scoverlogo);
                startActivity(intent);
            }
        });
    }


    @Override
    public void getCompanyProfileData(List<ProfileData> profileDatas) {

        sid = profileDatas.get(0).getId();
        scompanyname = profileDatas.get(0).getCompanyname();
        sgst = profileDatas.get(0).getGst();
        sregno = profileDatas.get(0).getCompanyregno();
        sphoneno = profileDatas.get(0).getCompanyphoneno();
        sdesc = profileDatas.get(0).getDescription();
        shrheadmail = profileDatas.get(0).getHrheademail();
        scompanymail = profileDatas.get(0).getCompanyemail();
        srootmail = profileDatas.get(0).getRootadministratoremail();
        syoe = profileDatas.get(0).getYearofestablish();
        swebsite = profileDatas.get(0).getWebsite();
        slink = profileDatas.get(0).getLinke();
        sindustry = profileDatas.get(0).getIndustry();
        slogo = profileDatas.get(0).getLogo();
        scoverlogo = profileDatas.get(0).getCoverimage();

        cmpnyimage = profileDatas.get(0).getLogo();
        coverimage = profileDatas.get(0).getCoverimage();
        mCompanyname.setText(profileDatas.get(0).getCompanyname());
        mYearofestablish.setText(profileDatas.get(0).getYearofestablish());
        mRegno.setText(profileDatas.get(0).getCompanyregno());
        mGst.setText(profileDatas.get(0).getGst());
        mHremail.setText(profileDatas.get(0).getHrheademail());
        mWebsite.setText(profileDatas.get(0).getWebsite());
        mCompanyemail.setText(profileDatas.get(0).getCompanyemail());
        mPhoneno.setText(profileDatas.get(0).getCompanyphoneno());
        mBusinesstype.setText(profileDatas.get(0).getIndustry());

        if (coverimage.equals("")) {
            mcmpnycoverimage.setImageResource(R.drawable.profile_bg);

        } else {
            Picasso.with(this).load(coverimage).into(mcmpnycoverimage);
        }
        if (cmpnyimage.equals("")) {

            mcmpnyprofilelogo.setImageResource(R.drawable.profile_icon);

        } else {
            //Download .png or .jpeg
            new GetImageFromUrl(mcmpnyprofilelogo).execute(cmpnyimage);
        }
        dialog.dismiss();
    }

    @Override
    public void Error() {
        dialog.dismiss();
    }

    //Class for download
    public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {

        ImageView imageView;

        public GetImageFromUrl(ImageView imageview1) {
            this.imageView = imageview1;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urldisplay = strings[0];
            mcmpnyprofilelogo = null;
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

    private void init() {

        mcmpnyprofilelogo = (ImageView) findViewById(R.id.company_pfle_logo);
        mcmpnycoverimage = (ImageView) findViewById(R.id.company_cover_image);
        mCompanyname = (TextView) findViewById(R.id.cpcompany_name);
        mYearofestablish = (TextView) findViewById(R.id.cpcompany_yoe);
        mRegno = (TextView) findViewById(R.id.cpcompany_regno);
        mGst = (TextView) findViewById(R.id.cpcompany_gst);
        mHremail = (TextView) findViewById(R.id.cpcompany_hr);
        mWebsite = (TextView) findViewById(R.id.cpcompany_website);
        mCompanyemail = (TextView) findViewById(R.id.cpcompany_cemail);
        mPhoneno = (TextView) findViewById(R.id.cpcompany_cphoneno);
        mBusinesstype = (TextView) findViewById(R.id.cpcompany_business_type);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
