package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.cboadz.app.cboardzsuperadmin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveRulesFragment extends Fragment {

    Spinner leaves_spinner;


    public LeaveRulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_leave_rules, container, false);

        leaves_spinner = (Spinner) view.findViewById(R.id.leaves_spinner);
        String spin= leaves_spinner.getSelectedItem().toString();

        return view;
    }

}
