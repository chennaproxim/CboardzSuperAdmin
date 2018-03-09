package com.cboadz.app.cboardzsuperadmin.Employees.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

public class EmpAddQuery extends AppCompatActivity {

    private EditText query_title,query_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_add_query);

        Toolbar toolbar = (Toolbar) findViewById(R.id.add_support_toolbar);
        query_title = (EditText) findViewById(R.id.query_title);
        query_desc = (EditText) findViewById(R.id.query_desc);

        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        if (Build.VERSION.SDK_INT > 19 ){
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        } else {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        findViewById(R.id.create_query_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (query_title.getText().toString().equals("")){
                    query_title.setError("Enter Data");
                    query_title.requestFocus();

                } else if (query_desc.getText().toString().equals("")){
                    query_desc.setError("Enter Data");
                    query_desc.requestFocus();
                } else {
                    Toast.makeText(EmpAddQuery.this, "Submitted Successully", Toast.LENGTH_SHORT).show();
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
