package com.cboadz.app.cboardzsuperadmin.Employees.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AlertUtility;

public class EmployeeDashboard extends AppCompatActivity {

    private TextView emp_dash_prfle_name, mp_dash_prfle_empid, emp_dash_prfle_designation, emp_prfle_cmpny_email
            , emp_prfle_scroll_content, emp_prfle_notifiction_count, emp_prfle_helpdesk_notifiction_count;

    private ImageView emp_prfle_photo, emp_prfle_cmpny_logo, emp_prfle_cmpny_cover_photo;
    private Pair<View, String> pair1, pair2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.employee_main_toolbar);
        setTitle("");
        setSupportActionBar(toolbar);

        findViewById(R.id.emply_announcements_cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeDashboard.this, EmployeeNotifications.class));
            }
        });
        findViewById(R.id.emply_leave_cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeDashboard.this, EmployeeLeaves.class));
            }
        });
        findViewById(R.id.emply_issues_cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeDashboard.this, EmployeeSupport.class));
            }
        });
        findViewById(R.id.emply_shop_cardview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EmployeeDashboard.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.emp_prfle_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeDashboard.this, EmployeeProfile.class);
                pair1 = Pair.create(findViewById(R.id.emp_prfle_photo), "employee_profile_img");
                pair2 = Pair.create(findViewById(R.id.emp_dash_prfle_name), "employee_name");
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(EmployeeDashboard.this, pair1, pair2);
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        emp_prfle_scroll_content.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        emp_prfle_scroll_content.setSingleLine(true);
        emp_prfle_scroll_content.setSelected(true);
    }

    private void init() {

        emp_prfle_scroll_content = (TextView) findViewById(R.id.emp_prfle_scroll_content);
        emp_dash_prfle_name = (TextView) findViewById(R.id.emp_dash_prfle_name);
        mp_dash_prfle_empid = (TextView) findViewById(R.id.emp_dash_prfle_empid);
        emp_dash_prfle_designation = (TextView) findViewById(R.id.emp_dash_prfle_designation);
        emp_prfle_cmpny_email = (TextView) findViewById(R.id.emp_prfle_cmpny_email);
        emp_prfle_notifiction_count = (TextView) findViewById(R.id.emp_prfle_notifiction_count);
        emp_prfle_helpdesk_notifiction_count = (TextView) findViewById(R.id.emp_prfle_helpdesk_notifiction_count);

        emp_prfle_photo = (ImageView) findViewById(R.id.emp_prfle_photo);
        emp_prfle_cmpny_logo = (ImageView) findViewById(R.id.emp_prfle_cmpny_logo);
        emp_prfle_cmpny_cover_photo = (ImageView) findViewById(R.id.emp_prfle_cmpny_cover_photo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_employee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.emplye__logout) {
            AlertUtility.exit(EmployeeDashboard.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertUtility.exit(EmployeeDashboard.this);
    }

}
