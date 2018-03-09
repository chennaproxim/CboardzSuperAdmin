package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Adapter.EmployeeListAdapter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeData;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeAllFragment extends Fragment {

    private RecyclerView mEmprecyclerview;
    private ProgressDialog progressDialog;
    private EmployeeListAdapter mEmployeeListAdapter;
    public List<EmployeeData> mEmpdata = new ArrayList<>();

    public EmployeeAllFragment(List<EmployeeData> mEmpresult) {
        // Required empty public constructor
        this.mEmpdata = mEmpresult;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_all, container, false);
        mEmprecyclerview = (RecyclerView) view.findViewById(R.id.emp_list_all_recycler_view);

        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        mEmployeeListAdapter = new EmployeeListAdapter(mEmpdata,getContext(),"All");
        final GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2);
        mEmprecyclerview.setLayoutManager(gridLayoutManager);
        mEmprecyclerview.setAdapter(mEmployeeListAdapter);
        progressDialog.dismiss();

        return view;
    }

}


