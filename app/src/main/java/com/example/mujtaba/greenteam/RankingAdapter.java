package com.example.mujtaba.greenteam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mujtaba on 12/31/2018.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder>  {
    private ArrayList<String> Team_name = new ArrayList<>();
    private ArrayList<String> Position = new ArrayList<>();
    private ArrayList<String> Rating = new ArrayList<>();

    public RankingAdapter(ArrayList<String> team_name, ArrayList<String> rating) {
        Team_name = team_name;
        Rating = rating;
    }

    @Override
    public RankingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_card,parent,false);
        return new RankingAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RankingAdapter.ViewHolder holder, int position) {
        String Temp = Team_name.get(position);
        holder.t2.setText(Temp);
        holder.t3.setText("Rating:- "+Rating.get(position));

        if (Temp.equals("England"))holder.img.setImageResource(R.drawable.ic_england);
        else if (Temp.equals("India")) holder.img.setImageResource(R.drawable.ic_india);
        else if (Temp.equals("Pakistan")) holder.img.setImageResource(R.drawable.ic_pakistan);
        else if (Temp.equals("Bangladesh")) holder.img.setImageResource(R.drawable.ic_bangladesh);
        else if (Temp.equals("Sri Lanka")) holder.img.setImageResource(R.drawable.ic_sri_lanka);
        else if (Temp.equals("New Zealand")) holder.img.setImageResource(R.drawable.ic_new_zealand);
        else if (Temp.equals("Australia")) holder.img.setImageResource(R.drawable.ic_australia);
        else if (Temp.equals("South Africa")) holder.img.setImageResource(R.drawable.ic_south_africa);
        else if (Temp.equals("Afghanistan")) holder.img.setImageResource(R.drawable.ic_afghanistan);
        else holder.img.setImageResource(R.drawable.ic_flag);


    }

    @Override
    public int getItemCount() {
        return Team_name.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView t2,t3,t4;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            t2=(TextView)itemView.findViewById(R.id.team_name);
            t3=(TextView)itemView.findViewById(R.id.team_ranking);
            img = (ImageView) itemView.findViewById(R.id.team_img);

        }
    }
}
