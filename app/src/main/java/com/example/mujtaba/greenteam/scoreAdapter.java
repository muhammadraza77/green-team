package com.example.mujtaba.greenteam;


/**
 * Created by users12 on 10/12/2018.
 */

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

public class scoreAdapter extends RecyclerView.Adapter<scoreAdapter.viewholder> {
    List<score> data;
    Context context;

    public scoreAdapter(List<score> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.live_score_home,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(final viewholder holder, int position) {
        final score a=data.get(position);
        holder.series.setText(a.series);
        holder.team1name.setText(a.team1);
        holder.team2name.setText(a.team2);
        holder.team1score.setText(a.team1Total);
        holder.team2score.setText(a.team2Total);
        holder.team1overs.setText(a.team1Overs);
        holder.team2overs.setText(a.team2Overs);

//        holder.toss.setText(a.tossWin);
        if (a.team1.equals("England"))holder.t1.setImageResource(R.drawable.ic_england);
        else if (a.team1.equals("India")) holder.t1.setImageResource(R.drawable.ic_india);
        else if (a.team1.equals("Pakistan")) holder.t1.setImageResource(R.drawable.ic_pakistan);
        else if (a.team1.equals("Bangladesh")) holder.t1.setImageResource(R.drawable.ic_bangladesh);
        else if (a.team1.equals("Sri Lanka")) holder.t1.setImageResource(R.drawable.ic_sri_lanka);
        else if (a.team1.equals("New Zealand")) holder.t1.setImageResource(R.drawable.ic_new_zealand);
        else if (a.team1.equals("Australia")) holder.t1.setImageResource(R.drawable.ic_australia);
        else if (a.team1.equals("South Africa")) holder.t1.setImageResource(R.drawable.ic_south_africa);
        else if (a.team1.equals("Afghanistan")) holder.t1.setImageResource(R.drawable.ic_afghanistan);
        else holder.t1.setImageResource(R.color.colorAccent);

        if (a.team2.equals("England"))holder.t2.setImageResource(R.drawable.ic_england);
        else if (a.team2.equals("India")) holder.t2.setImageResource(R.drawable.ic_india);
        else if (a.team2.equals("Pakistan")) holder.t2.setImageResource(R.drawable.ic_pakistan);
        else if (a.team2.equals("Bangladesh")) holder.t2.setImageResource(R.drawable.ic_bangladesh);
        else if (a.team2.equals("Sri Lanka")) holder.t2.setImageResource(R.drawable.ic_sri_lanka);
        else if (a.team2.equals("New Zealand")) holder.t2.setImageResource(R.drawable.ic_new_zealand);
        else if (a.team2.equals("Australia")) holder.t2.setImageResource(R.drawable.ic_australia);
        else if (a.team2.equals("South Africa")) holder.t2.setImageResource(R.drawable.ic_south_africa);
        else if (a.team2.equals("Afghanistan")) holder.t2.setImageResource(R.drawable.ic_afghanistan);
        else holder.t2.setImageResource(R.color.colorAccent);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView t1,t2;
        TextView team1name,team2name,team1score,team2score,team1overs,team2overs,toss,series;
        LinearLayout bt;
        public viewholder(View itemView) {
            super(itemView);
            team1name=(TextView)itemView.findViewById(R.id.team1);
            team2name=(TextView)itemView.findViewById(R.id.team2);
            team1score=(TextView)itemView.findViewById(R.id.team1score1);
            team2score=(TextView)itemView.findViewById(R.id.team2score1);
            team1overs = (TextView)itemView.findViewById(R.id.team1overs1);
            team2overs = (TextView)itemView.findViewById(R.id.team2overs1);
            t1= (ImageView) itemView.findViewById(R.id.team1image);
            t2= (ImageView) itemView.findViewById(R.id.team2image);

            series=(TextView)itemView.findViewById(R.id.series);

        }
    }
}

