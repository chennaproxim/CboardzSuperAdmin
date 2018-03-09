package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CreateCompanyResultDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CreateCompanyPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CreateCompanyPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CreateCompanyView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.restApi.CameraPermission;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility.isValidEmail;

public class CreateCompany extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, CreateCompanyView {

    private Toolbar toolbar;
    private Spinner spinner;
    CircleImageView clientImage, delete_image, upload_image_plus;
    ImageView company_cover_image, upload_cover;
    String spinner_data;
    private String companyname, description, year, regno, gst, hrheadmail, website, companyemail, phoneno, rootadminemail,
            link, defaultpass;
    private EditText cmpnyname, cmpny_des, ccmpny_year, cmpny_reg_no, cmpny_gst, cmpny_hr_head_email, cmpny_website,
            cmpny_cmpny_email, cmpny_phne_no, cmpny_root_adminmail, cmpny_link, cmpny_default_password;

    private int SELECT_FILE = 1;
    private Bitmap bitmap = null, resized = null, resized1 = null, bitmap1 = null;
    private String userChoosenTask;
    public File logo, coverimage, destination;

    CreateCompanyPresenter mcreateCompanyPresenter;
    CreateCompanyResultDTO mcreateCompanyResultDTO;
    private ProgressDialog dialog;

    private int imageid = 0;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_company);

        init();
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        spinner.setOnItemSelectedListener(this);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        final String token = preferences.getString("tokenkey", String.valueOf(0));

        mcreateCompanyResultDTO = new CreateCompanyResultDTO();
        mcreateCompanyPresenter = new CreateCompanyPresenterImpl(CreateCompany.this);

        upload_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageid = 1;
                selectImage();
            }
        });

        clientImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageid = 0;
                selectImage();
            }
        });

        findViewById(R.id.crt_cmpny_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                companyname = cmpnyname.getText().toString();
                description = cmpny_des.getText().toString();
                year = ccmpny_year.getText().toString();
                regno = cmpny_reg_no.getText().toString();
                gst = cmpny_gst.getText().toString();
                hrheadmail = cmpny_hr_head_email.getText().toString();
                website = cmpny_website.getText().toString();
                companyemail = cmpny_cmpny_email.getText().toString();
                phoneno = cmpny_phne_no.getText().toString();
                rootadminemail = cmpny_root_adminmail.getText().toString();
                defaultpass = cmpny_default_password.getText().toString();
                link = cmpny_link.getText().toString();
                if (companyname.equals("")) {
                    cmpnyname.requestFocus();
                    cmpnyname.setError("Enter data");
                } else if (description.equals("")) {
                    cmpny_des.requestFocus();
                    cmpny_des.setError("Enter data");
                } else if (year.equals("")) {
                    ccmpny_year.requestFocus();
                    ccmpny_year.setError("Enter data");
                } else if (regno.equals("")) {
                    cmpny_reg_no.requestFocus();
                    cmpny_reg_no.setError("Enter data");
                } else if (gst.equals("")) {
                    cmpny_gst.requestFocus();
                    cmpny_gst.setError("Enter data");
                } else if (!isValidEmail(hrheadmail)) {
                    cmpny_hr_head_email.requestFocus();
                    cmpny_hr_head_email.setError("Enter Valid Email");
                } else if (website.equals("")) {
                    cmpny_website.requestFocus();
                    cmpny_website.setError("Enter data");
                } else if (!isValidEmail(companyemail)) {
                    cmpny_cmpny_email.requestFocus();
                    cmpny_cmpny_email.setError("Enter Valid Email");
                } else if (phoneno.equals("")) {
                    cmpny_phne_no.requestFocus();
                    cmpny_phne_no.setError("Enter data");
                } else if (!isValidEmail(rootadminemail)) {
                    cmpny_root_adminmail.requestFocus();
                    cmpny_root_adminmail.setError("Enter Valid Email");
                } else if (link.equals("")) {
                    cmpny_link.requestFocus();
                    cmpny_link.setError("Enter data");
                } else if (defaultpass.equals("")) {
                    cmpny_default_password.requestFocus();
                    cmpny_default_password.setError("Enter data");
                } else {
                    dialog = new ProgressDialog(CreateCompany.this, R.style.MyAlertDialogStyle);
                    dialog.setMessage(AppConstants.CREATING);
                    dialog.show();
                    mcreateCompanyPresenter.sendComapnyData(companyname, gst, regno, phoneno, description, hrheadmail, companyemail,
                            rootadminemail, year, website, link, spinner_data, defaultpass, token, logo, coverimage);
                }
            }
        });

    }

    private void selectImage() {
        final CharSequence[] items = {"Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateCompany.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = CameraPermission.checkPermission(CreateCompany.this);

                if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();

                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                if (imageid == 0) {
                    imagetoString(data);
                    onSelectFromGalleryResult(data);
                } else {
                    imagetoString(data);
                }
        }
    }

    private void imagetoString(Intent data) {

        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        android.database.Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        if (cursor == null)
            return;

        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();

        if (imageid == 0) {
            try {
                logo = new File(filePath);
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            try {
                coverimage = new File(filePath);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {

        if (data != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(CreateCompany.this.getContentResolver(), data.getData());
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                if (height > 2000 && width > 2000) {
                    resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.4), (int) (bitmap.getHeight() * 0.4), true);
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                    destination = new File(Environment.getExternalStorageDirectory(),
                            System.currentTimeMillis() + ".jpg");
                } else {
                    resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.7), (int) (bitmap.getHeight() * 0.7), true);
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                    destination = new File(Environment.getExternalStorageDirectory(),
                            System.currentTimeMillis() + ".jpg");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (imageid == 0) {
            clientImage.setImageBitmap(resized);
        }
        else {
            Toast.makeText(this, "Cover Image Uploaded", Toast.LENGTH_SHORT).show();
        }

    }

    private void init() {

        clientImage = (CircleImageView) findViewById(R.id.upload_image);
        delete_image = (CircleImageView) findViewById(R.id.delete_image);
        upload_image_plus = (CircleImageView) findViewById(R.id.upload_image_plus);
        company_cover_image = (ImageView) findViewById(R.id.company_cover_image);
        upload_cover = (ImageView) findViewById(R.id.upload_cover);
        toolbar = (Toolbar) findViewById(R.id.crt_compny_toolbar);
        spinner = (Spinner) findViewById(R.id.create_cmpny_spinner);
        cmpnyname = (EditText) findViewById(R.id.cmpny_cmpnyname);
        cmpny_des = (EditText) findViewById(R.id.cmpny_desc);
        ccmpny_year = (EditText) findViewById(R.id.cmpny_year);
        cmpny_reg_no = (EditText) findViewById(R.id.cmpny_reg_no);
        cmpny_gst = (EditText) findViewById(R.id.cmpny_gst);
        cmpny_hr_head_email = (EditText) findViewById(R.id.cmpny_hr_head_email);
        cmpny_website = (EditText) findViewById(R.id.cmpny_website);
        cmpny_cmpny_email = (EditText) findViewById(R.id.cmpny_cmpny_email);
        cmpny_phne_no = (EditText) findViewById(R.id.cmpny_phne_no);
        cmpny_root_adminmail = (EditText) findViewById(R.id.cmpny_root_adminmail);
        cmpny_link = (EditText) findViewById(R.id.cmpny_link);
        cmpny_default_password = (EditText) findViewById(R.id.cmpny_default_password);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        spinner_data = (adapterView.getSelectedItem()).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void clearFields() {
        cmpnyname.setText("");
        cmpny_des.setText("");
        ccmpny_year.setText("");
        cmpny_reg_no.setText("");
        cmpny_gst.setText("");
        cmpny_hr_head_email.setText("");
        cmpny_website.setText("");
        cmpny_cmpny_email.setText("");
        cmpny_phne_no.setText("");
        cmpny_root_adminmail.setText("");
        cmpny_link.setText("");
        cmpny_default_password.setText("");
    }

    @Override
    public void Error() {
        dialog.dismiss();
        Toast.makeText(this, "Error pasing data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void uploadResult(CreateCompanyResultDTO createCompanyResultDTO) {
        dialog.dismiss();
        Toast.makeText(this, "" + createCompanyResultDTO.getResponse(), Toast.LENGTH_SHORT).show();
    }
}
