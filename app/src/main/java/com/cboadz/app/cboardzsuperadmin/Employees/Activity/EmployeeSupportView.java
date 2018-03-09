package com.cboadz.app.cboardzsuperadmin.Employees.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

public class EmployeeSupportView extends AppCompatActivity {

    private EditText employee_view_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_support_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.emply_support_reply_toolbar);
        employee_view_notice = (EditText) findViewById(R.id.employee_view_notice);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        findViewById(R.id.employee_notice_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (employee_view_notice.getText().toString().equals("")){
                    employee_view_notice.requestFocus();
                    Toast.makeText(EmployeeSupportView.this, "Can't send empty message", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(EmployeeSupportView.this, "message sent", Toast.LENGTH_LONG).show();
                    employee_view_notice.setText("");
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
