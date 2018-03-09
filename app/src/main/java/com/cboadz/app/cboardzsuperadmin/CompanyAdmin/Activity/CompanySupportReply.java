package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

public class CompanySupportReply extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText company_support_reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_support_reply);

        toolbar = (Toolbar) findViewById(R.id.company_support_reply_toolbar);
        company_support_reply = (EditText)findViewById(R.id.company_support_reply);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.company_support_reply_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (company_support_reply.getText().toString().equals("")){
                    company_support_reply.requestFocus();
                    Toast.makeText(CompanySupportReply.this, "Can't send empty message", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CompanySupportReply.this, "message sent", Toast.LENGTH_LONG).show();
                    company_support_reply.setText("");
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