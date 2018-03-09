package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificatiionsSettingFragment extends Fragment {


    public NotificatiionsSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_notificatiions_setting, container, false);

        return view;
    }

}
