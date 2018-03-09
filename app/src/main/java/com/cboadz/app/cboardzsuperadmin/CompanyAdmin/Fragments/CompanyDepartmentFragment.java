package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity.CreateBusinessHeadActivity;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Activity.CreateDeaprtmentActivity;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Adapter.BusinessHeadDeapartmentAdapter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.BusinessHeadDepartmentListDTO;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Businessheadlist;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Departmentlist;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Model.BusinessHeadDepartmentPresenterImpl;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Presenter.BusinessHeadDepartmentPresenter;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.View.BusinessHeadDepartmentView;
import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.Utils.AppConstants;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyDepartmentFragment extends Fragment implements BusinessHeadDepartmentView{

    private RecyclerView mCompanyRecyclerView;
    private BusinessHeadDepartmentPresenter mBusinessHeadDepartmentPresenter;
    private BusinessHeadDepartmentListDTO mBusinessHeadDepartmentListDTO;
    private ProgressDialog progressDialog;
    private BusinessHeadDeapartmentAdapter mBusinessHeadDeapartmentAdapter;

    public CompanyDepartmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_department, container, false);

        mCompanyRecyclerView = (RecyclerView) view.findViewById(R.id.company_department_recycler_view);

        progressDialog = new ProgressDialog(getActivity(), R.style.MyAlertDialogStyle);
        progressDialog.setMessage(AppConstants.LOADING);
        progressDialog.show();
        mBusinessHeadDepartmentListDTO = new BusinessHeadDepartmentListDTO();
        mBusinessHeadDepartmentPresenter = new BusinessHeadDepartmentPresenterImpl((BusinessHeadDepartmentView) getActivity());
        mBusinessHeadDepartmentPresenter.sendBusinessHeadDepartmentId("5a93f7fffc0b4c05583a2fd5","686e9f293456e3fb42d81a2f2641411f86365341ecb00767d6515605ca234120789809519c7a5efbbce4aa761f5d335eab88bc7b7e30d22cc11ec9322f341710");


        view.findViewById(R.id.menu_business).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CreateBusinessHeadActivity.class));
            }
        });

        view.findViewById(R.id.menu_department).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CreateDeaprtmentActivity.class));
            }
        });

        return view;
    }

    @Override
    public void getBusinessHeadResponce(List<Businessheadlist> businessheadlist) {

        progressDialog.dismiss();
        mBusinessHeadDeapartmentAdapter = new BusinessHeadDeapartmentAdapter(businessheadlist,getContext(),"businessheadlist");

    }

    @Override
    public void getDeaprtmentResponce(List<Departmentlist> departmentlist) {

        progressDialog.dismiss();
        mBusinessHeadDeapartmentAdapter = new BusinessHeadDeapartmentAdapter(departmentlist,getContext());

    }

    @Override
    public void getErrorResponce(String responce) {

        progressDialog.dismiss();
        Toast.makeText(getContext(), responce, Toast.LENGTH_SHORT).show();

    }
}
