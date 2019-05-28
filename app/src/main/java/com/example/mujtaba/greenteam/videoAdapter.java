package com.example.mujtaba.greenteam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pedrovgs.DraggablePanel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class videoAdapter extends RecyclerView.Adapter<videoAdapter.viewholder> {
        Context context;
    List<video> vdata;



    public videoAdapter(List<video> data,Context context) {
        vdata= data;
        this.context = context;
    }


    @Override
    public videoAdapter.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card,parent,false);

        return new viewholder(v);
    }

    @Override

    public void onBindViewHolder(videoAdapter.viewholder holder, int position) {

        final video a=vdata.get(position);
        Picasso.with(context).load(a.getThumbnail()).fit().into(holder.thumb);
        holder.video_title.setText(a.getTitle());
        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                video_fragment.draggableView.setVisibility(View.VISIBLE);
                video_fragment.draggableView.maximize();

            }
        });

    }

    @Override
    public int getItemCount() {
        return vdata.size();
    }

        public static class viewholder extends RecyclerView.ViewHolder {
            public LinearLayout l1;
            private ImageView thumb;
            private TextView video_title;
            public viewholder(View itemView) {
                super(itemView);
                l1=(LinearLayout) itemView.findViewById(R.id.clickablelayout);
                thumb = (ImageView)itemView.findViewById(R.id.thumbnail);
                video_title = (TextView)itemView.findViewById(R.id.desc);
            }

        }

}
