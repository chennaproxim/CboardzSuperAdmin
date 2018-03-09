package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Adapter.CompanyListAdapter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompnyListAll extends Fragment {

    private RecyclerView company_list_all_recycler_view;
    private ProgressDialog progressDialog;
    private CompanyListAdapter adapter;
    public ArrayList<CompanyListData> mallresult = new ArrayList<>();

    public CompnyListAll() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compny_list_all, container, false);

        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        Bundle bundle = getArguments();
        mallresult = (ArrayList<CompanyListData>) bundle.getSerializable("companyarrays");

        company_list_all_recycler_view = (RecyclerView) view.findViewById(R.id.company_list_all_recycler_view);
        adapter = new CompanyListAdapter(mallresult, getContext());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        progressDialog.dismiss();
        company_list_all_recycler_view.setLayoutManager(layoutManager);
        company_list_all_recycler_view.setAdapter(adapter);

        return view;
    }

}
