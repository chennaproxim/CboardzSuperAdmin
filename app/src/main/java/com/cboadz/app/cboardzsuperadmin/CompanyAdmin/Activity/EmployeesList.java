package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeData;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeListDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.EmployeeActiveFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.EmployeeAllFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.EmployeeInActiveFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.EmployeeSuspendFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.EmployeeTerminateFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model.EmployeeListPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.EmployeeListPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.EmployeeListView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeesList extends AppCompatActivity implements EmployeeListView {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar emplys_list_toolbar;
    private String mToken, mLoginId;
    private SharedPreferences preferences;
    public List<EmployeeData> mEmpresult = new ArrayList<>();

    private EmployeeListPresenter memployeeListPresenter;
    private EmployeeListDTO memployeeListDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_list);

        emplys_list_toolbar = (Toolbar) findViewById(R.id.emplys_list_toolbar);
        setSupportActionBar(emplys_list_toolbar);
        setTitle("");

        preferences = getSharedPreferences(AppConstants.TOKEN, MODE_PRIVATE);
        mToken = preferences.getString("tokenkey", String.valueOf(1));
        mLoginId = preferences.getString("loginid", String.valueOf(1));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.emplys_viewpager);

        tabLayout = (TabLayout) findViewById(R.id.emplys_list_tab);
        tabLayout.setupWithViewPager(viewPager);


        memployeeListDTO = new EmployeeListDTO();
        memployeeListPresenter = new EmployeeListPresenterImpl(EmployeesList.this);
        memployeeListPresenter.sendEmployeesData(mLoginId, mToken);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_emply_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeesList.this, CreateEmployeeActivity.class));
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EmployeeAllFragment(mEmpresult), "All");
        adapter.addFragment(new EmployeeActiveFragment(mEmpresult), "Active");
        adapter.addFragment(new EmployeeInActiveFragment(mEmpresult), "InActive");
        adapter.addFragment(new EmployeeTerminateFragment(mEmpresult), "Terminated");
        adapter.addFragment(new EmployeeSuspendFragment(mEmpresult), "Suspended");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void showEmployeesList(List<EmployeeData> getEmployeeData) {
        if (getEmployeeData.size() > 0) {
            mEmpresult.clear();
            mEmpresult = getEmployeeData;
            setupViewPager(viewPager);
        }
    }

    @Override
    public void onError(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_serach, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
