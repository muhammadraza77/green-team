package com.example.mujtaba.greenteam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by users12 on 10/8/2018.
 */

public class newsAdapter2 extends RecyclerView.Adapter<newsAdapter2.viewholder> {

    List<newInfo> data;
    Context context;

    public newsAdapter2(List<newInfo> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public newsAdapter2.viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card2,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(final newsAdapter2.viewholder holder, int position) {
        final newInfo a=data.get(position);
        holder.t.setText(a.title);
        Picasso.with(context).load(a.thumbnail).fit().into(holder.i);

        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(context,newsDetail.class);
                i.putExtra("info",a);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView i;
        TextView t;
        LinearLayout bt;
        public viewholder(View itemView) {
            super(itemView);
            i=(ImageView)itemView.findViewById(R.id.picture);
            t=(TextView)itemView.findViewById(R.id.heading);
            bt=(LinearLayout)itemView.findViewById(R.id.bt);
        }
    }
}
