package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

import com.cboadz.app.cboardzsuperadmin.R;

public class CreateLeaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_leave);

        Toolbar toolbar = (Toolbar) findViewById(R.id.create_leave_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Spinner leaves_spinner = (Spinner) findViewById(R.id.leaves_frequency_spinner);
        String spin= leaves_spinner.getSelectedItem().toString();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
