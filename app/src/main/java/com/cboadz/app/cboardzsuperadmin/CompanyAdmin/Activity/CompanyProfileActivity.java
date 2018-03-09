package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.CompanyDepartmentFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.CompanyProfileFragment;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments.CompanySettingsFragment;
import com.cboadz.app.cboardzsuperadmin.R;

import java.util.ArrayList;
import java.util.List;

public class CompanyProfileActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile2);

        toolbar = (Toolbar) findViewById(R.id.cmpny_prfle_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.cmpny_prfle_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.cmpny_prfle_list_tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CompanyProfileFragment(), "Profile");
        adapter.addFragment(new CompanyDepartmentFragment(), "Departments");
        adapter.addFragment(new CompanySettingsFragment(), "Settings");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
