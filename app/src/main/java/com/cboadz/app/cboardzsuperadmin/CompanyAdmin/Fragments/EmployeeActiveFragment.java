package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Adapter.EmployeeListAdapter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeData;
import com.cboadz.app.cboardzsuperadmin.Employees.Activity.EmployeeProfile;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeActiveFragment extends Fragment {

    private RecyclerView mEmprecyclerview;
    private ProgressDialog progressDialog;
    private EmployeeListAdapter mEmployeeListAdapter;
    public List<EmployeeData> mEmpData = new ArrayList<>();
    public List<EmployeeData> mEmpdataActive = new ArrayList<>();

    public EmployeeActiveFragment(List<EmployeeData> mEmpresult) {
        // Required empty public constructor
        this.mEmpData = mEmpresult;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_active, container, false);
        mEmprecyclerview = (RecyclerView) view.findViewById(R.id.emp_list_active_recycler_view);

        mEmpdataActive.clear();
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        int count = mEmpData.size();

        for (int i = 0; i < mEmpData.size(); i++) {
            if (mEmpData.get(i).getStatustype().equals("Active")) {
                mEmpdataActive.add(mEmpData.get(i));
            }
        }

        int countting = mEmpdataActive.size();

        mEmployeeListAdapter = new EmployeeListAdapter(mEmpdataActive,getContext(),"All");
        final GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2);
        mEmprecyclerview.setLayoutManager(gridLayoutManager);
        mEmprecyclerview.setAdapter(mEmployeeListAdapter);
        progressDialog.dismiss();

        return  view;
    }

}
