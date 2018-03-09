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
public class EmployeeInActiveFragment extends Fragment {

    private RecyclerView mEmprecyclerview;
    private ProgressDialog progressDialog;
    private EmployeeListAdapter mEmployeeListAdapter;
    public List<EmployeeData> mEmpData = new ArrayList<>();
    public List<EmployeeData> mEmpdataInActive = new ArrayList<>();


    public EmployeeInActiveFragment(List<EmployeeData> mEmpresult) {
        // Required empty public constructor
        this.mEmpData = mEmpresult;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_in_active, container, false);

        mEmprecyclerview = (RecyclerView) view.findViewById(R.id.emp_list_Inactive_recycler_view);

        mEmpdataInActive.clear();
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        for (int i = 0; i < mEmpData.size(); i++) {

            if (mEmpData.get(i).getStatustype().equals("InActive")) {
                mEmpdataInActive.add(mEmpData.get(i));
            }
        }

        mEmployeeListAdapter = new EmployeeListAdapter(mEmpdataInActive,getContext(),"InActive");
        final GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2);
        mEmprecyclerview.setLayoutManager(gridLayoutManager);
        mEmprecyclerview.setAdapter(mEmployeeListAdapter);
        progressDialog.dismiss();

        return view ;
    }

}
