package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity.CreateCompany;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyProfileFragment extends Fragment {

    private TextView mCompany_name, mCompany_YOE, mCompany_RegNo, mCompany_GST, mCompany_HrEmail
            , mCompany_Website, mCompany_Mail, mCompany_PhoneNo, mCompany_Business_Type;
    private ImageView mCompany_Icon;
    private ProgressDialog mProgressDialog;


    public CompanyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_profile, container, false);

        initializing(view);
        mProgressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        mProgressDialog.setMessage(AppConstants.FETCHING);
        mProgressDialog.show();

        setData();

        return view;
    }

    private void setData() {

        SharedPreferences companyPreferenes = getActivity().getSharedPreferences(AppConstants.COMPANYPROFILEDATA, MODE_PRIVATE);
        Picasso.with(getActivity()).load(companyPreferenes.getString("companylogo", String.valueOf(1))).fit().into(mCompany_Icon);
        mCompany_name.setText(companyPreferenes.getString("companyname", String.valueOf(1)));
        mCompany_YOE.setText(companyPreferenes.getString("companyyoe", String.valueOf(1)));
        mCompany_RegNo.setText(companyPreferenes.getString("companyreg", String.valueOf(1)));
        mCompany_GST.setText(companyPreferenes.getString("companygst", String.valueOf(1)));
        mCompany_HrEmail.setText(companyPreferenes.getString("companyhrheadmail", String.valueOf(1)));
        mCompany_Website.setText(companyPreferenes.getString("companywebsite", String.valueOf(1)));
        mCompany_Mail.setText(companyPreferenes.getString("companymail", String.valueOf(1)));
        mCompany_PhoneNo.setText(companyPreferenes.getString("companyphone", String.valueOf(1)));
        mCompany_Business_Type.setText(companyPreferenes.getString("companybusinesstype", String.valueOf(1)));
        mProgressDialog.dismiss();

    }

    private void initializing(View view) {

        mCompany_name = (TextView) view.findViewById(R.id.mCompany_name);
        mCompany_YOE = (TextView) view.findViewById(R.id.mCompany_YOE);
        mCompany_RegNo = (TextView) view.findViewById(R.id.mCompany_Reg_No);
        mCompany_GST = (TextView) view.findViewById(R.id.mCompany_GST);
        mCompany_HrEmail = (TextView) view.findViewById(R.id.mCompany_HR_Mail);
        mCompany_Website = (TextView) view.findViewById(R.id.mCompany_Website);
        mCompany_Mail = (TextView) view.findViewById(R.id.mCompany_Mail);
        mCompany_PhoneNo = (TextView) view.findViewById(R.id.mCompany_Phone);
        mCompany_Business_Type = (TextView) view.findViewById(R.id.mCompany_Business_Type);
        mCompany_Icon = (ImageView) view.findViewById(R.id.mCompany_Icon);

    }

}
