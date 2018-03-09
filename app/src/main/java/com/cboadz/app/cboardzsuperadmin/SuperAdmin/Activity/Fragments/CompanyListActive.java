package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity.CompanyProfile;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyListActive extends Fragment {


    public CompanyListActive() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_company_list_active, container, false);

        view.findViewById(R.id.comapny_list1_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CompanyProfile.class));
            }
        });

        return view;
    }

}
