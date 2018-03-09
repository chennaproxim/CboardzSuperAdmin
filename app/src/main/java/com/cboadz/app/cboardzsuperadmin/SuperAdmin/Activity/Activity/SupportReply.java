package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

public class SupportReply extends AppCompatActivity {

    private Toolbar toolbar;
private EditText company_view_notice;
    private TextView name_change1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_reply);

        toolbar = (Toolbar) findViewById(R.id.support_reply_toolbar);
        company_view_notice = (EditText) findViewById(R.id.company_view_notice);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.company_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportReply.this,CompanyProfile.class));
            }
        });

        findViewById(R.id.company_notice_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (company_view_notice.getText().toString().equals("")){
                    company_view_notice.requestFocus();
                    Toast.makeText(SupportReply.this, "Can't send empty message", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(SupportReply.this, "message sent", Toast.LENGTH_SHORT).show();
                    company_view_notice.setText("");
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
