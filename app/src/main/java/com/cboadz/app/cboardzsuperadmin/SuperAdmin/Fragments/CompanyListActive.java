package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.CompanyProfile;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyListActive extends Fragment {

    public ArrayList<CompanyListData> mresultall = new ArrayList<>();
    private RecyclerView mCmpnyrecyclerview;
    private ProgressDialog progressDialog;
    public ArrayList<CompanyListData> mresutlActive = new ArrayList<>();
    public ArrayList<CompanyListData> mresultData = new ArrayList<>();
    private String message;
    private ImageView norecords;

    public CompanyListActive(ArrayList<CompanyListData> mresult1) {
        // Required empty public constructor
        this.mresutlActive = mresult1;
    }

    public CompanyListActive(String msg){

        this.message = msg;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_company_list_active, container, false);
        mCmpnyrecyclerview = (RecyclerView) view.findViewById(R.id.emp_list_active_recycler_view);

        norecords = (ImageView) view.findViewById(R.id.company_Active_records_image);
//        mresultall.clear();
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        if (message.equals("No records found")) {
            norecords.setVisibility(View.VISIBLE);
            progressDialog.dismiss();
        }

//        for (int i = 0; i < mresutlActive.size(); i++) {
//            if (mresutlActive.get(i).getc().equals("Active")) {
//                mresultData.add(mresutlActive.get(i));
//            }
//        }


        return view;
    }

}
