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
public class EmployeeTerminateFragment extends Fragment {

    private RecyclerView mEmprecyclerview;
    private ProgressDialog progressDialog;
    private EmployeeListAdapter mEmployeeListAdapter;
    public List<EmployeeData> mEmpTerminatedData = new ArrayList<>();
    public List<EmployeeData> mEmpdata = new ArrayList<>();

    public EmployeeTerminateFragment(List<EmployeeData> mEmpresult) {
        // Required empty public constructor
        this.mEmpdata = mEmpresult;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_terminate, container, false);
        mEmprecyclerview = (RecyclerView) view.findViewById(R.id.emp_list_terminated_recycler_view);

        mEmpTerminatedData.clear();
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        for (int i = 0; i < mEmpdata.size(); i++) {

            if (mEmpdata.get(i).getStatustype().equals("Terminated")) {
                mEmpTerminatedData.add(mEmpdata.get(i));
            }
        }

        mEmployeeListAdapter = new EmployeeListAdapter(mEmpTerminatedData,getContext(),"Terminated");
        final GridLayoutManager gridLayoutManager =new GridLayoutManager(getActivity(),2);
        mEmprecyclerview.setLayoutManager(gridLayoutManager);
        mEmprecyclerview.setAdapter(mEmployeeListAdapter);
        progressDialog.dismiss();

        return  view;
    }

}
