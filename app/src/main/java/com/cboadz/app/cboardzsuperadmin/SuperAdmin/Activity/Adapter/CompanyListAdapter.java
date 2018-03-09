package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Activity.CompanyProfile;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.CompanyListDTO.CompanyListData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Proxim on 3/5/2018.
 */

public class CompanyListAdapter extends RecyclerView.Adapter<CompanyListAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<CompanyListData> allcompanylist;
    Pair<View, String> pair1;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_company_list_all, parent, false);
        return new MyViewHolder(itemView);
    }

    public CompanyListAdapter(ArrayList<CompanyListData> companylist, Context mcontext) {

        this.allcompanylist = companylist;
        this.mcontext = mcontext;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        CompanyListData actors = allcompanylist.get(position);
        holder.company_name.setText(allcompanylist.get(position).getCompanyemail());
        holder.company_mail.setText(allcompanylist.get(position).getCompanyname());
        if (actors.getLogo().equals("")) {
            holder.company_logo.setImageResource(R.drawable.profile_icon);

        } else {
            Picasso.with(mcontext).load(actors.getLogo()).fit().into(holder.company_logo);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mcontext, CompanyProfile.class);
                intent.putExtra("id", allcompanylist.get(position).getId());
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allcompanylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView company_name, company_mail;
        public CircleImageView company_logo;

        public MyViewHolder(View view) {
            super(view);
            company_name = (TextView) view.findViewById(R.id.sa_company_email);
            company_logo = (CircleImageView) view.findViewById(R.id.sa_copany_logo);
            company_mail = (TextView) view.findViewById(R.id.sa_company_name);
        }
    }

}
