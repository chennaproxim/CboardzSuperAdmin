package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Adapter;

/**
 * Created by Proxim on 2/27/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.ViewNotice;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo.Companyid;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.DTO.NoticesListDTo.NoticesDatum;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class NoticesListAdapter extends RecyclerView.Adapter<NoticesListAdapter.MyViewHolder> {

    private Context mcontext;

    private ArrayList<NoticesDatum> mnoticesDatumArrayList;
    private ArrayList<Companyid> mcompanyids;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notices_list_all, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoticesListAdapter.MyViewHolder holder, final int position) {

        holder.mnoticetitle.setText(mnoticesDatumArrayList.get(position).getTitle());
        holder.mnoticedec.setText(mnoticesDatumArrayList.get(position).getDescription());
        holder.mnoticetime.setText(mnoticesDatumArrayList.get(position).getTime());
        if (mnoticesDatumArrayList.get(position).getTitletype().equals("holiday")) {
            holder.mnoticeicon.setImageResource(R.drawable.holiday);
            holder.mview.setBackgroundColor(Color.GREEN);
        } else if (mnoticesDatumArrayList.get(position).getTitletype().equals("teamlunch")) {
            holder.mnoticeicon.setImageResource(R.drawable.dinner);
            holder.mview.setBackgroundColor(Color.BLUE);
        }else if (mnoticesDatumArrayList.get(position).getTitletype().equals("problem")) {
            holder.mnoticeicon.setImageResource(R.drawable.problem);
            holder.mview.setBackgroundColor(Color.RED);
        }else if (mnoticesDatumArrayList.get(position).getTitletype().equals("leave")) {
            holder.mnoticeicon.setImageResource(R.drawable.leave);
            holder.mview.setBackgroundColor(Color.RED);
        }else if (mnoticesDatumArrayList.get(position).getTitletype().equals("other")) {
            holder.mnoticeicon.setImageResource(R.drawable.others);
            holder.mview.setBackgroundColor(Color.MAGENTA);
        }else if (mnoticesDatumArrayList.get(position).getTitletype().equals("appissue")) {
            holder.mnoticeicon.setImageResource(R.drawable.application_issue);
            holder.mview.setBackgroundColor(Color.YELLOW);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewNotice.class);
                intent.putExtra("notice_title",mnoticesDatumArrayList.get(position).getTitle());
                intent.putExtra("notice_id",mnoticesDatumArrayList.get(position).getId());
                intent.putExtra("notice_type",mnoticesDatumArrayList.get(position).getTitletype());
                v.getContext().startActivity(intent);
            }
        });
    }

    public NoticesListAdapter(ArrayList<NoticesDatum> noticeslist, Context context) {
        this.mnoticesDatumArrayList = noticeslist;
        this.mcontext = context;

    }

    @Override
    public int getItemCount() {
        return mnoticesDatumArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mnoticetitle, mnoticedec,mnoticetime;
        public CircleImageView mnoticeicon;
        public View mview;

        public MyViewHolder(View view) {
            super(view);
            mnoticetitle = (TextView) view.findViewById(R.id.ntc_title);
            mnoticeicon = (CircleImageView) view.findViewById(R.id.ntc_icon);
            mnoticedec = (TextView) view.findViewById(R.id.ntc_description);
            mnoticetime = (TextView) view.findViewById(R.id.ntc_time);
            mview = (View) view.findViewById(R.id.notice_type);
        }
    }

}
