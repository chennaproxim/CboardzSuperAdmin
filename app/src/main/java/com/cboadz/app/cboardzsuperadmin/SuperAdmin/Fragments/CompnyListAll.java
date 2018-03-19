package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.CompaniesListActivity;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Adapter.CompanyListAdapter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanyListData;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.CompanyListDTO.CompanylistResult;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Model.CompanyListModel.CompanylistAllPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Presenter.CompanyListPresenter.CompanylistAllPresenter;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.View.CompanyListView.CompanylistAllView;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompnyListAll extends Fragment implements CompanylistAllView, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView company_list_all_recycler_view;
    private ProgressDialog progressDialog;
    private CompanyListAdapter adapter;
    public ArrayList<CompanyListData> mresultall = new ArrayList<>();
    private ImageView norecords;
    private CompanylistAllPresenter mcompanylistAllPresenter;
    private CompanylistResult mcompanylistResultDTO;
    private String token;
    private SharedPreferences preferences;
    private SwipeRefreshLayout mCompanyallRefresh;

    public CompnyListAll() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compny_list_all, container, false);


        company_list_all_recycler_view = (RecyclerView) view.findViewById(R.id.company_list_all_recycler_view);
        mCompanyallRefresh = (SwipeRefreshLayout) view.findViewById(R.id.company_list_all_refresh);
        norecords = (ImageView) view.findViewById(R.id.company_all_records_image);
        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();

        preferences = getActivity().getSharedPreferences(AppConstants.TOKEN, Context.MODE_PRIVATE);
        token = preferences.getString("tokenkey", String.valueOf(1));

        mcompanylistResultDTO = new CompanylistResult();
        mcompanylistAllPresenter = new CompanylistAllPresenterImpl(CompnyListAll.this);
        mcompanylistAllPresenter.getAllCompanylist(token);

        mCompanyallRefresh.setOnRefreshListener(this);


        return view;
    }

    @Override
    public void showcompaniesList(ArrayList<CompanyListData> getcompanylist) {

        mresultall = getcompanylist;
        adapter = new CompanyListAdapter(getcompanylist, getContext());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        progressDialog.dismiss();
        mCompanyallRefresh.setRefreshing(false);
        company_list_all_recycler_view.setLayoutManager(layoutManager);
        company_list_all_recycler_view.setAdapter(adapter);

    }

    @Override
    public void dataNotfound(String msg) {

    }

    @Override
    public void onRefresh() {

        mcompanylistAllPresenter.getAllCompanylist(token);
    }
}
