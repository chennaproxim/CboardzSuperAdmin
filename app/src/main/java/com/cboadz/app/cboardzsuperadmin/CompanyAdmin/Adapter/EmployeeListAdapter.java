package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.EmployeeList.EmployeeData;
import com.cboadz.app.cboardzsuperadmin.Employees.Activity.EmployeeProfile;
import com.cboadz.app.cboardzsuperadmin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Proxim on 3/5/2018.
 */

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.MyEmpViewHolder> {

    private Context mcontext;
    private List<EmployeeData> allEmployeesList;
    private String mStatusType;

    @Override
    public MyEmpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_emp_list_all, parent, false);
        return new MyEmpViewHolder(itemView);
    }

    public EmployeeListAdapter(List<EmployeeData> companylist, Context context, String statustype) {

        this.allEmployeesList = companylist;
        this.mcontext = context;
        this.mStatusType = statustype;

    }

    @Override
    public void onBindViewHolder(final EmployeeListAdapter.MyEmpViewHolder holder, final int position) {

        EmployeeData actors = allEmployeesList.get(position);

        if (mStatusType.equals("All")) {

            holder.mEmpName.setText(allEmployeesList.get(position).getFirstname());
            holder.mEmpDesignation.setText(allEmployeesList.get(position).getDesignation());
            if (actors.getProfilephoto().equals("")) {
                holder.mEmpPic.setImageResource(R.drawable.profile_icon);

            } else {
                Picasso.with(mcontext).load(actors.getProfilephoto()).fit().into(holder.mEmpPic);
            }
        } else {

            holder.mEmpName.setText(allEmployeesList.get(position).getFirstname());
            holder.mEmpDesignation.setText(allEmployeesList.get(position).getDesignation());
            if (actors.getProfilephoto().equals("")) {
                holder.mEmpPic.setImageResource(R.drawable.profile_icon);

            } else {
                Picasso.with(mcontext).load(actors.getProfilephoto()).fit().into(holder.mEmpPic);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), EmployeeProfile.class);
                intent.putExtra("empid", allEmployeesList.get(position).getId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allEmployeesList.size();
    }

    public class MyEmpViewHolder extends RecyclerView.ViewHolder {
        public TextView mEmpName, mEmpDesignation;
        public CircleImageView mEmpPic;

        public MyEmpViewHolder(View view) {
            super(view);
            mEmpName = (TextView) view.findViewById(R.id.emp_name);
            mEmpPic = (CircleImageView) view.findViewById(R.id.emp_profile_pic);
            mEmpDesignation = (TextView) view.findViewById(R.id.emp_designation);
        }
    }

}