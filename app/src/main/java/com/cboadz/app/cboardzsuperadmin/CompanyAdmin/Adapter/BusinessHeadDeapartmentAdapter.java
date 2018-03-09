package com.cboadz.app.cboardzsuperadmin.CompanyAdmin.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Businessheadlist;
import com.cboadz.app.cboardzsuperadmin.CompanyAdmin.DTO.BusinessHeadDepartment.Departmentlist;
import com.cboadz.app.cboardzsuperadmin.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Proxim on 3/7/2018.
 */

public class BusinessHeadDeapartmentAdapter extends RecyclerView.Adapter<BusinessHeadDeapartmentAdapter.MyViewHolder> {

    private List<Businessheadlist> mBusinessheadlists;
    private List<Departmentlist> mDepartmentlists;
    private Context mcontext;
    private String mDepartmenttype = "";

    public BusinessHeadDeapartmentAdapter(List<Businessheadlist> businessheadlist, Context context, String businessheadlist1) {

        this.mBusinessheadlists = businessheadlist;
        this.mcontext = context;
        this.mDepartmenttype = businessheadlist1;

    }

    public BusinessHeadDeapartmentAdapter(List<Departmentlist> departmentlist, Context context) {

        this.mDepartmentlists = departmentlist;
        this.mcontext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_emp_list_all, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        if (mDepartmenttype.equals("businessheadlist")){

            holder.mHeading.setText("Business Head");

            holder.mDeaprtmentName.setText(mBusinessheadlists.get(position).getBusinessheadname());
            String test = mBusinessheadlists.get(position).getBusinessheadname();
            char first = test.charAt(0);
            holder.mDeaprtmentName.setText(first);

        } else {

            holder.mHeading.setText("Departments");
            holder.mDeaprtmentName.setText(mDepartmentlists.get(position).getPersonname());
            String test = mBusinessheadlists.get(position).getBusinessheadname();
            char first = test.charAt(0);
            holder.mDeaprtmentName.setText(first);

        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mHeading, mDeaprtmentName,mDepartmentFirstLetter;
        public CircleImageView mCirclerImage;
        public ImageView mCall,mMail;

        public MyViewHolder(View view) {
            super(view);

            mHeading = (TextView)view.findViewById(R.id.deapartment_title);
            mDeaprtmentName = (TextView)view.findViewById(R.id.deapartment_head_name);
            mDepartmentFirstLetter = (TextView)view.findViewById(R.id.deapartment_first_letter);
            mCall = (ImageView) view.findViewById(R.id.business_phone_call_btn);
            mMail = (ImageView) view.findViewById(R.id.business_mail_btn);
            mCirclerImage = (CircleImageView) view.findViewById(R.id.deapartment_circler_image);

        }
    }
}
