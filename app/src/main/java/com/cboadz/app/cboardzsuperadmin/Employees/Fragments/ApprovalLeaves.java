package com.cboadz.app.cboardzsuperadmin.Employees.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.Employees.Activity.ViewEmployeeNotification;
import com.cboadz.app.cboardzsuperadmin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApprovalLeaves extends Fragment {


    public ApprovalLeaves() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_approval_leave, container, false);

        view.findViewById(R.id.leaves_sick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ViewEmployeeNotification.class));
            }
        });

        return  view;
    }

}
