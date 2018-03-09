package com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.Adapter;

/**
 * Created by Proxim on 2/27/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.cboadz.app.cboardzsuperadmin.SuperAdmin.Activity.DTO.ViewNoticeDTO.Conversation;

import java.util.ArrayList;


public class NoticeViewConversationAdapter extends RecyclerView.Adapter<NoticeViewConversationAdapter.MyViewHolder> {

    private Context mcontext;

    private ArrayList<Conversation> conversationArrayList;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_notice_convesation, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        if (conversationArrayList.get(position).getCreatedBy() != null){
            holder.ntcview_conversation_companyname.setText(conversationArrayList.get(position).getCreatedBy());
        }
        if (conversationArrayList.get(position).getMessage() != null){
            holder.ntcview_conversation_desc.setText(conversationArrayList.get(position).getMessage());
        }
        if (conversationArrayList.get(position).getDate() != null){
            holder.ntcview_conversation_date.setText(conversationArrayList.get(position).getDate());
        }
        if (conversationArrayList.get(position).getTime() != null){
            holder.ntcview_conversation_time.setText(conversationArrayList.get(position).getTime());
        }

    }

    public NoticeViewConversationAdapter(ArrayList<Conversation> conversations, Context context) {
        this.conversationArrayList = conversations;
        this.mcontext = context;

    }

    @Override
    public int getItemCount() {
        return conversationArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView ntcview_conversation_companyname, ntcview_conversation_desc, ntcview_conversation_date, ntcview_conversation_time;

        public MyViewHolder(View view) {
            super(view);
            ntcview_conversation_companyname = (TextView) view.findViewById(R.id.ntcview_conversation_companyname);
            ntcview_conversation_desc = (TextView) view.findViewById(R.id.ntcview_conversation_desc);
            ntcview_conversation_date = (TextView) view.findViewById(R.id.ntcview_conversation_date);
            ntcview_conversation_time = (TextView) view.findViewById(R.id.ntcview_conversation_time);
        }
    }

}

