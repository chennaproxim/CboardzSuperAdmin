package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.cboadz.app.cboardzsuperadmin.R.id.issues_pop;

public class CompanyAddNotice extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Dialog myDialog;
    private CircleImageView holiday_pop, dinner_pop, issue_pop, leave_pop, others_pop, app_issue_pop;
    private CircleImageView circlerview;
    private LinearLayout cmpny_addntce_deparment_name;
    private EditText cmpny_notice_title, cmpny_notice_desc;
    private String noticetitle, noticedesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_add_notice);

        circlerview = (CircleImageView) findViewById(R.id.pop_upshow);
        toolbar = (Toolbar) findViewById(R.id.company_add_notice_toolbar);
        cmpny_notice_title = (EditText) findViewById(R.id.cmpny_notice_title);
        cmpny_notice_desc = (EditText) findViewById(R.id.cmpny_notice_desc);

        cmpny_addntce_deparment_name = (LinearLayout) findViewById(R.id.cmpny_addntce_deparment_name);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final CheckBox cmpny_addnotice_checkBox = (CheckBox) findViewById(R.id.cmpny_addnotice_checkBox);
        cmpny_addnotice_checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cmpny_addnotice_checkBox.isChecked()) {
                    cmpny_addntce_deparment_name.setVisibility(View.GONE);
                } else {
                    cmpny_addntce_deparment_name.setVisibility(View.VISIBLE);
                }
            }
        });

        findViewById(R.id.cmpny_notice_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                noticetitle = cmpny_notice_title.getText().toString();
                noticedesc = cmpny_notice_desc.getText().toString();

                if (noticetitle.equals("")) {
                    cmpny_notice_title.requestFocus();
                    cmpny_notice_title.setError("Enter data");
                } else if (noticedesc.equals("")) {
                    cmpny_notice_desc.requestFocus();
                    cmpny_notice_desc.setError("Enter data");
                } else {
                    Toast.makeText(CompanyAddNotice.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ShowPopup(View v) {
        Button yes;
        final Dialog dialog = new Dialog(CompanyAddNotice.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.company_notice_popup);
        // Set dialog title
        dialog.setTitle("Custom Dialog");
        yes = (Button) dialog.findViewById(R.id.yes);
        holiday_pop = (CircleImageView) dialog.findViewById(R.id.holiday_pop);
        dinner_pop = (CircleImageView) dialog.findViewById(R.id.dinner_pop);
        issue_pop = (CircleImageView) dialog.findViewById(issues_pop);
        leave_pop = (CircleImageView) dialog.findViewById(R.id.leave_pop);
        others_pop = (CircleImageView) dialog.findViewById(R.id.others_pop);
        app_issue_pop = (CircleImageView) dialog.findViewById(R.id.app_issue_pop);
        dialog.show();
        holiday_pop.setOnClickListener(this);
        dinner_pop.setOnClickListener(this);
        issue_pop.setOnClickListener(this);
        leave_pop.setOnClickListener(this);
        others_pop.setOnClickListener(this);
        app_issue_pop.setOnClickListener(this);
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
            case R.id.dinner_pop:
                circlerview.setImageResource(R.drawable.dinner);
                dinner_pop.setBorderColor(Color.BLUE);
                holiday_pop.setBorderColor(Color.TRANSPARENT);
                leave_pop.setBorderColor(Color.TRANSPARENT);
                issue_pop.setBorderColor(Color.TRANSPARENT);
                others_pop.setBorderColor(Color.TRANSPARENT);
                app_issue_pop.setBorderColor(Color.TRANSPARENT);
                break;
            case R.id.holiday_pop:
                circlerview.setImageResource(R.drawable.holiday);
                holiday_pop.setBorderColor(Color.BLUE);
                dinner_pop.setBorderColor(Color.TRANSPARENT);
                leave_pop.setBorderColor(Color.TRANSPARENT);
                issue_pop.setBorderColor(Color.TRANSPARENT);
                others_pop.setBorderColor(Color.TRANSPARENT);
                app_issue_pop.setBorderColor(Color.TRANSPARENT);
                break;
            case issues_pop:
                circlerview.setImageResource(R.drawable.problem);
                issue_pop.setBorderColor(Color.BLUE);
                holiday_pop.setBorderColor(Color.TRANSPARENT);
                leave_pop.setBorderColor(Color.TRANSPARENT);
                dinner_pop.setBorderColor(Color.TRANSPARENT);
                others_pop.setBorderColor(Color.TRANSPARENT);
                app_issue_pop.setBorderColor(Color.TRANSPARENT);
                break;
            case R.id.leave_pop:
                circlerview.setImageResource(R.drawable.leave);
                leave_pop.setBorderColor(Color.BLUE);
                holiday_pop.setBorderColor(Color.TRANSPARENT);
                dinner_pop.setBorderColor(Color.TRANSPARENT);
                issue_pop.setBorderColor(Color.TRANSPARENT);
                others_pop.setBorderColor(Color.TRANSPARENT);
                app_issue_pop.setBorderColor(Color.TRANSPARENT);
                break;
            case R.id.others_pop:
                circlerview.setImageResource(R.drawable.others);
                others_pop.setBorderColor(Color.BLUE);
                holiday_pop.setBorderColor(Color.TRANSPARENT);
                leave_pop.setBorderColor(Color.TRANSPARENT);
                issue_pop.setBorderColor(Color.TRANSPARENT);
                dinner_pop.setBorderColor(Color.TRANSPARENT);
                app_issue_pop.setBorderColor(Color.TRANSPARENT);
                break;
            case R.id.app_issue_pop:
                circlerview.setImageResource(R.drawable.application_issue);
                app_issue_pop.setBorderColor(Color.BLUE);
                holiday_pop.setBorderColor(Color.TRANSPARENT);
                leave_pop.setBorderColor(Color.TRANSPARENT);
                issue_pop.setBorderColor(Color.TRANSPARENT);
                others_pop.setBorderColor(Color.TRANSPARENT);
                dinner_pop.setBorderColor(Color.TRANSPARENT);
                break;
        }
    }
}
