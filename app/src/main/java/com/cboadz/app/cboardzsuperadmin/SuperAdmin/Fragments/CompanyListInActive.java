package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyListInActive extends Fragment {

    public ArrayList<CompanyListData> mresultInActive = new ArrayList<>();
    private String message;
    private ProgressDialog progressDialog;
    private ImageView norecords;


    public CompanyListInActive() {
        // Required empty public constructor
//        this.mresultInActive = mresult1;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_list_in_active, container, false);
        norecords = (ImageView) view.findViewById(R.id.company_InActive_records_image);
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
//        progressDialog.show();

        return view;
    }

}
