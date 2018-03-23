package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.CreateEmployeeDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model.CreateEmployeePresenterImpl;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.CreateEmployeePresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.CreateEmployeeView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.cboadz.app.cboardzsuperadmin.Permissions.CameraPermission;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility.isValidEmail;

public class CreateEmployeeActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, CreateEmployeeView {

    private Toolbar toolbar;
    private final int IMG_REQUEST = 2;
    private Spinner mStatusSpinner;
    String mToken = "", mLoginId = "", gender = "";
    private SharedPreferences preferences;
    private CircleImageView emp_upload_image;
    private EditText mEmpId, mEmpFirstName, mEmpLastName, mEmpCompanyMail, mEmpPhone, mEmpDepartmemnt, mEmpDesignation, mEmpAddress, mEmpBlood, mEmpReportingManager, mEmpMail, mEmpPassword;
    private String id, firstname, lastname, cmpnyemai, empphone, empdepart, empdesign, empaddress, empblood, empreprmanager, empemail, mStatusType, mEmpPass;
    String mUserChoosen;
    private int SELECT_FILE = 1;
    File mEmpPicFile, destination;
    private Bitmap bitmap = null, resized = null;
    private ProgressDialog dialog;

    private CreateEmployeePresenter mCreateEmployeePresenter;
    ;
    private CreateEmployeeDTO mCreateEmployeeDTO;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);

        emp_upload_image = (CircleImageView) findViewById(R.id.emp_upload_image);
        mEmpId = (EditText) findViewById(R.id.crt_emp_id);
        mEmpFirstName = (EditText) findViewById(R.id.crt_emp_first);
        mEmpLastName = (EditText) findViewById(R.id.crt_emp_last);
        mEmpCompanyMail = (EditText) findViewById(R.id.crt_emp_compny_email);
        mEmpPhone = (EditText) findViewById(R.id.crt_emp_phone);
        mEmpDepartmemnt = (EditText) findViewById(R.id.crt_emp_department);
        mEmpDesignation = (EditText) findViewById(R.id.crt_emp_designation);
        mEmpAddress = (EditText) findViewById(R.id.crt_emp_address);
        mEmpBlood = (EditText) findViewById(R.id.crt_emp_blood);
        mEmpReportingManager = (EditText) findViewById(R.id.crt_emp_rept_manager);
        mEmpMail = (EditText) findViewById(R.id.crt_emp_email);
        mEmpPassword = (EditText) findViewById(R.id.crt_emp_password);
        mStatusSpinner = (Spinner) findViewById(R.id.emp_status_spinner);

        toolbar = (Toolbar) findViewById(R.id.add_employee_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        mToken = preferences.getString("tokenkey", String.valueOf(1));
        mLoginId = preferences.getString("loginid", String.valueOf(1));

        mCreateEmployeeDTO = new CreateEmployeeDTO();
        mCreateEmployeePresenter = new CreateEmployeePresenterImpl(CreateEmployeeActivity.this);

        emp_upload_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empselectImage();
            }
        });

        findViewById(R.id.crt_emp_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = mEmpId.getText().toString();
                firstname = mEmpFirstName.getText().toString();
                lastname = mEmpLastName.getText().toString();
                cmpnyemai = mEmpCompanyMail.getText().toString();
                empphone = mEmpPhone.getText().toString();
                empdepart = mEmpDepartmemnt.getText().toString();
                empdesign = mEmpDesignation.getText().toString();
                empaddress = mEmpAddress.getText().toString();
                empblood = mEmpBlood.getText().toString();
                empreprmanager = mEmpReportingManager.getText().toString();
                empemail = mEmpMail.getText().toString();
                mEmpPass = mEmpPassword.getText().toString();

                if (id.equals("")) {
                    mEmpId.requestFocus();
                    mEmpId.setError("Enter data");
                } else if (firstname.equals("")) {
                    mEmpFirstName.requestFocus();
                    mEmpFirstName.setError("Enter data");
                } else if (lastname.equals("")) {
                    mEmpLastName.requestFocus();
                    mEmpLastName.setError("Enter data");
                } else if (!isValidEmail(cmpnyemai)) {
                    mEmpCompanyMail.requestFocus();
                    mEmpCompanyMail.setError("Enter Valid Email");
                } else if (empphone.equals("")) {
                    mEmpPhone.requestFocus();
                    mEmpPhone.setError("Enter data");
                } else if (empdepart.equals("")) {
                    mEmpDepartmemnt.requestFocus();
                    mEmpDepartmemnt.setError("Enter data");
                } else if (empdesign.equals("")) {
                    mEmpDesignation.requestFocus();
                    mEmpDesignation.setError("Enter data");
                } else if (empaddress.equals("")) {
                    mEmpAddress.requestFocus();
                    mEmpAddress.setError("Enter data");
                } else if (empblood.equals("")) {
                    mEmpBlood.requestFocus();
                    mEmpBlood.setError("Enter data");
                } else if (empreprmanager.equals("")) {
                    mEmpReportingManager.requestFocus();
                    mEmpReportingManager.setError("Enter data");
                } else if (TextUtils.isEmpty(mEmpPass)) {
                    mEmpPassword.requestFocus();
                    mEmpPassword.setError("Enter data");
                } else if (!isValidEmail(empemail)) {
                    mEmpMail.requestFocus();
                    mEmpMail.setError("Enter Valid Email");
                } else {
                    dialog = new ProgressDialog(CreateEmployeeActivity.this, R.style.MyAlertDialogStyle);
                    dialog.setMessage(AppConstants.CREATING);
                    dialog.show();

                    mCreateEmployeePresenter.sendEmployeeDetails(id, firstname, lastname, cmpnyemai, empphone, empdepart, empdesign
                            , empaddress, empblood, empreprmanager, gender, empemail, mStatusType, mToken, mEmpPicFile, mLoginId, mEmpPass);
                }
            }
        });
        mStatusSpinner.setOnItemSelectedListener(this);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.emp_male:
                if (checked)
                    gender = "Male";
                Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.emp_female:
                if (checked)
                    gender = "FeMale";
                Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void empselectImage() {
        final CharSequence[] items = {"Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(CreateEmployeeActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = CameraPermission.checkPermission(CreateEmployeeActivity.this);

                if (items[item].equals("Choose from Library")) {
                    mUserChoosen = "Choose from Library";
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
                imagetoString(data);
                onSelectImageFromGallery(data);
        } else {
            imagetoString(data);
        }
    }

    private void onSelectImageFromGallery(Intent data) {

        if (data != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(CreateEmployeeActivity.this.getContentResolver(), data.getData());
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

        emp_upload_image.setImageBitmap(resized);

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

        try {
            mEmpPicFile = new File(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        mStatusType = (parent.getSelectedItem()).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void showEmployeeCreatedStatus(CreateEmployeeDTO createEmployeeDTO) {

        progressDialog.dismiss();
        Toast.makeText(this, createEmployeeDTO.getResponse(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String msg) {

        progressDialog.dismiss();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
