package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CreateNoticeDTO;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CreateNoticePresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CreateNoticePresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CreateNoticeView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.cboadz.app.cboardzsuperadmin.R.id.app_issue_pop;
import static com.cboadz.app.cboardzsuperadmin.R.id.dinner_pop;
import static com.cboadz.app.cboardzsuperadmin.R.id.holiday_pop;
import static com.cboadz.app.cboardzsuperadmin.R.id.issues_pop;
import static com.cboadz.app.cboardzsuperadmin.R.id.leave_pop;
import static com.cboadz.app.cboardzsuperadmin.R.id.others_pop;

public class AddNotice extends AppCompatActivity implements View.OnClickListener, CreateNoticeView {

    private Toolbar toolbar;
    private CircleImageView circlerview;
    private EditText cmpny_notice_title, cmpny_notice_desc, cmpny_notice_name;
    private Button cmpny_notice_post;
    private String noticetitle, noticedesc;
    private CircleImageView holiday_pop1, dinner_pop1, issue_pop1, leave_pop1, others_pop1, app_issue_pop1;
    String titletype = "holiday";
    private SharedPreferences preferences;
    private String token, id = "5a94e1074f329e06c0a30e00";
    private LinearLayout company_view_notice;
    private CheckBox checkBox;
    private ProgressDialog mprogressDialog;
    private CreateNoticePresenter mcreatenoticepresenter;
    private CreateNoticeDTO mcreatenoticeDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);

        init();

        mcreatenoticeDTO = new CreateNoticeDTO();
        mcreatenoticepresenter = new CreateNoticePresenterImpl(AddNotice.this);
        mprogressDialog = new ProgressDialog(AddNotice.this, R.style.MyAlertDialogStyle);
        mprogressDialog.setMessage(AppConstants.SENDING);

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        token = preferences.getString("tokenkey", String.valueOf(1));

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkBox.isChecked()) {
                    company_view_notice.setVisibility(View.GONE);
                } else {
                    company_view_notice.setVisibility(View.VISIBLE);
                }
            }
        });


        cmpny_notice_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                noticetitle = cmpny_notice_title.getText().toString();
                noticedesc = cmpny_notice_desc.getText().toString();

                if (TextUtils.isEmpty(noticetitle)) {
                    cmpny_notice_title.requestFocus();
                    cmpny_notice_title.setError("Enter data");
                } else if (TextUtils.isEmpty(noticedesc)) {
                    cmpny_notice_desc.requestFocus();
                    cmpny_notice_desc.setError("Enter data");
                } else {
                    mprogressDialog.show();
                    mcreatenoticepresenter.addNotice(noticetitle, titletype, noticedesc, id, token);
                }
            }
        });
    }

    private void init() {

        circlerview = (CircleImageView) findViewById(R.id.pop_upshow1);
        toolbar = (Toolbar) findViewById(R.id.add_notice_toolbar);
        cmpny_notice_title = (EditText) findViewById(R.id.cmpny_notice_title);
        cmpny_notice_desc = (EditText) findViewById(R.id.cmpny_notice_desc);
        cmpny_notice_name = (EditText) findViewById(R.id.cmpny_notice_name);
        cmpny_notice_post = (Button) findViewById(R.id.cmpny_notice_post);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        company_view_notice = (LinearLayout) findViewById(R.id.company_view_notice);

    }

    public void ShowPopup1(View v) {
        Button yes;
        final Dialog dialog = new Dialog(AddNotice.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.company_notice_popup);
        // Set dialog title
        dialog.setTitle("Custom Dialog");
        yes = (Button) dialog.findViewById(R.id.yes);
        holiday_pop1 = (CircleImageView) dialog.findViewById(R.id.holiday_pop);
        dinner_pop1 = (CircleImageView) dialog.findViewById(R.id.dinner_pop);
        issue_pop1 = (CircleImageView) dialog.findViewById(R.id.issues_pop);
        leave_pop1 = (CircleImageView) dialog.findViewById(R.id.leave_pop);
        others_pop1 = (CircleImageView) dialog.findViewById(R.id.others_pop);
        app_issue_pop1 = (CircleImageView) dialog.findViewById(R.id.app_issue_pop);
        dialog.show();
        holiday_pop1.setOnClickListener(this);
        dinner_pop1.setOnClickListener(this);
        issue_pop1.setOnClickListener(this);
        leave_pop1.setOnClickListener(this);
        others_pop1.setOnClickListener(this);
        app_issue_pop1.setOnClickListener(this);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case dinner_pop:
                titletype = "teamlunch";
                circlerview.setImageResource(R.drawable.dinner);
                dinner_pop1.setBorderColor(Color.BLUE);
                holiday_pop1.setBorderColor(Color.TRANSPARENT);
                leave_pop1.setBorderColor(Color.TRANSPARENT);
                issue_pop1.setBorderColor(Color.TRANSPARENT);
                others_pop1.setBorderColor(Color.TRANSPARENT);
                app_issue_pop1.setBorderColor(Color.TRANSPARENT);
                break;
            case holiday_pop:
                titletype = "holiday";
                circlerview.setImageResource(R.drawable.holiday);
                holiday_pop1.setBorderColor(Color.BLUE);
                dinner_pop1.setBorderColor(Color.TRANSPARENT);
                leave_pop1.setBorderColor(Color.TRANSPARENT);
                issue_pop1.setBorderColor(Color.TRANSPARENT);
                others_pop1.setBorderColor(Color.TRANSPARENT);
                app_issue_pop1.setBorderColor(Color.TRANSPARENT);
                break;
            case issues_pop:
                titletype = "problem";
                circlerview.setImageResource(R.drawable.problem);
                issue_pop1.setBorderColor(Color.BLUE);
                holiday_pop1.setBorderColor(Color.TRANSPARENT);
                leave_pop1.setBorderColor(Color.TRANSPARENT);
                dinner_pop1.setBorderColor(Color.TRANSPARENT);
                others_pop1.setBorderColor(Color.TRANSPARENT);
                app_issue_pop1.setBorderColor(Color.TRANSPARENT);
                break;
            case leave_pop:
                titletype = "leave";
                circlerview.setImageResource(R.drawable.leave);
                leave_pop1.setBorderColor(Color.BLUE);
                holiday_pop1.setBorderColor(Color.TRANSPARENT);
                dinner_pop1.setBorderColor(Color.TRANSPARENT);
                issue_pop1.setBorderColor(Color.TRANSPARENT);
                others_pop1.setBorderColor(Color.TRANSPARENT);
                app_issue_pop1.setBorderColor(Color.TRANSPARENT);
                break;
            case others_pop:
                titletype = "other";
                circlerview.setImageResource(R.drawable.others);
                others_pop1.setBorderColor(Color.BLUE);
                holiday_pop1.setBorderColor(Color.TRANSPARENT);
                leave_pop1.setBorderColor(Color.TRANSPARENT);
                issue_pop1.setBorderColor(Color.TRANSPARENT);
                dinner_pop1.setBorderColor(Color.TRANSPARENT);
                app_issue_pop1.setBorderColor(Color.TRANSPARENT);
                break;
            case app_issue_pop:
                titletype = "appissue";
                circlerview.setImageResource(R.drawable.application_issue);
                app_issue_pop1.setBorderColor(Color.BLUE);
                holiday_pop1.setBorderColor(Color.TRANSPARENT);
                leave_pop1.setBorderColor(Color.TRANSPARENT);
                issue_pop1.setBorderColor(Color.TRANSPARENT);
                others_pop1.setBorderColor(Color.TRANSPARENT);
                dinner_pop1.setBorderColor(Color.TRANSPARENT);
                break;
        }
    }

    @Override
    public void addNoticeResponce(CreateNoticeDTO createNoticeDTO) {

        mprogressDialog.dismiss();
        clearFields();
        Toast.makeText(this, createNoticeDTO.getResponse(), Toast.LENGTH_SHORT).show();

    }

    private void clearFields() {
        cmpny_notice_title.setText("");
        cmpny_notice_desc.setText("");
        cmpny_notice_name.setText("");
    }

    @Override
    public void Error() {
        mprogressDialog.dismiss();
        Toast.makeText(this, "Error Posting Data", Toast.LENGTH_SHORT).show();
    }
}
