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
public class CompanyListOnHold extends Fragment {

    public ArrayList<CompanyListData> mresutlOnHold = new ArrayList<>();
    private String message;
    private ProgressDialog progressDialog;
    private ImageView norecords;

    public CompanyListOnHold() {
        // Required empty public constructor
//        this.mresutlOnHold = mresult1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_company_list_on_hold, container, false);
        norecords = (ImageView) view.findViewById(R.id.company_Hold_records_image);
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
//        progressDialog.show();

        return view;
    }

}
