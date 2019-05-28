package com.example.mujtaba.greenteam;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class frag3Adapter extends RecyclerView.Adapter<frag3Adapter.MyViewHolder> {

    private ArrayList<String> match_name = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> series_name= new ArrayList<>();
    private ArrayList<String> match_result= new ArrayList<>();

    private int lastPosition = -1;

    public frag3Adapter(ArrayList<String> match_name, ArrayList<String> date, ArrayList<String> series_name,ArrayList<String> result) {
        this.match_name = match_name;
        this.date = date;
        this.series_name= series_name;
        this.match_result=result;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, date, series, result;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.matchname);
            date = (TextView) view.findViewById(R.id.date);
            series = (TextView) view.findViewById(R.id.matchtyp);
            result = (TextView) view.findViewById(R.id.result);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewseries) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag3card, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(match_name.get(position));
        holder.date.setText(date.get(position));
        holder.series.setText(series_name.get(position));
        holder.result.setText(match_result.get(position));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }
}