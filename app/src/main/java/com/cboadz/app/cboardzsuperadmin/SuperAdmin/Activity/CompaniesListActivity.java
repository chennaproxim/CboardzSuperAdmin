package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity;

import android.app.ProgressDialog;
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

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanylistResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments.CompanyListActive;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments.CompanyListInActive;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments.CompanyListOnHold;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments.CompnayListSuspend;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments.CompnyListAll;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CompanyListModel.CompanylistAllPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CompanyListPresenter.CompanylistAllPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CompanyListView.CompanylistAllView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class CompaniesListActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar cmpny_list_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_list);

        cmpny_list_toolbar = (Toolbar) findViewById(R.id.cmpny_list_toolbar);
        setSupportActionBar(cmpny_list_toolbar);
        setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.cmpny_viewpager);

        tabLayout = (TabLayout) findViewById(R.id.cmpny_list_tab);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_comapany_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(CompaniesListActivity.this,CreateCompany.class));
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CompnyListAll(), "All");
        adapter.addFragment(new CompanyListActive(), "Active");
        adapter.addFragment(new CompanyListInActive(), "Inactive");
        adapter.addFragment(new CompnayListSuspend(), "Suspended");
        adapter.addFragment(new CompanyListOnHold(), "OnHold");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        private final ArrayList<ArrayList<CompanyListData>> mresult= new ArrayList<>();

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
        startActivity(new Intent(CompaniesListActivity.this,MainActivity.class));
        return true;
    }
}
