package com.cboadz.app.cboardzsuperadmin.Employees.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.Employees.Fragments.ApprovalLeaves;
import com.cboadz.app.cboardzsuperadmin.Employees.Fragments.LeaveBalance;
import com.cboadz.app.cboardzsuperadmin.Employees.Fragments.NewLeaveRequest;
import com.cboadz.app.cboardzsuperadmin.R;

public class EmployeeLeaves extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView toolbar_heading;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_avalible:
                    LeaveBalance leaveBalance = new LeaveBalance();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.content, leaveBalance);
                    ft.commit();
                    return true;
                case R.id.navigation_applied:
                    ApprovalLeaves approvalLeaves = new ApprovalLeaves();
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction ft1 = fragmentManager1.beginTransaction();
                    ft1.replace(R.id.content, approvalLeaves);
                    ft1.commit();
                    return true;
                case R.id.navigation_newrequest:
                    NewLeaveRequest newLeaveRequest = new NewLeaveRequest();
                    FragmentManager fragmentManager2 = getSupportFragmentManager();
                    FragmentTransaction ft2 = fragmentManager2.beginTransaction();
                    ft2.replace(R.id.content, newLeaveRequest);
                    ft2.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_leaves);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        LeaveBalance leaveBalance = new LeaveBalance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content, leaveBalance);
        ft.commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.emplys_leave_page_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar_heading = (TextView) findViewById(R.id.leave_page_heading);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
