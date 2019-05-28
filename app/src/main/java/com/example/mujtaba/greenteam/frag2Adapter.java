package com.example.mujtaba.greenteam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mujtaba on 10/14/2018.
 */

public class frag2Adapter extends RecyclerView.Adapter<frag2Adapter.ViewHolder> {
    public frag2Adapter(ArrayList<String> match_name, ArrayList<String> date, ArrayList<String> series_name, ArrayList<String> match_time,ArrayList<Boolean> x) {
        this.match_name = match_name;
        this.date = date;
        this.series_name = series_name;
        this.match_time = match_time;
        this.extra=x;
    }

    private ArrayList<String> match_name = new ArrayList<>();
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> series_name= new ArrayList<>();
    private ArrayList<String> match_time= new ArrayList<>();
    private ArrayList<Boolean> extra= new ArrayList<>();

    @Override

        public frag2Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag2card,parent,false);
        return new frag2Adapter.ViewHolder(v);
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.t1.setText(match_name.get(position));
        holder.t3.setText(date.get(position));
        holder.t2.setText(series_name.get(position));
        holder.t4.setText(match_time.get(position));
        if(!extra.get(position))holder.live.setVisibility(View.INVISIBLE);
//        Toast.makeText(context, "____", Toast.LENGTH_SHORT).show();
//        for(int i=0;i<title.size();i++){
//            String str=title.get(position);
//            String[] parts = str.split(", ", 2);
//            String string1 = parts[0];
//            String string2 = parts[1];
//            String[] parts1 = string1.split("at ", 2);
//            String string3 = parts1[0];
//            String string4 = parts1[1];
//
////            Toast.makeText(context, string1+"**\n"+string2, Toast.LENGTH_SHORT).show();
//            holder.t1.setText(string3.toString());
//            holder.t2.setText(string4.toString());
//            holder.t3.setText(date.get(position));
//            holder.t4.setText(string2.toString());
//
//        }
    }

    @Override
    public int getItemCount() {
        return match_name.size();
    }

public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView t1;
    TextView t2,t3,t4,live;

    public ViewHolder(View itemView) {
        super(itemView);
        live = (TextView)itemView.findViewById(R.id.Live);
        t1=(TextView)itemView.findViewById(R.id.title);
        t2=(TextView)itemView.findViewById(R.id.loc);
        t3=(TextView)itemView.findViewById(R.id.matchDate);
        t4=(TextView)itemView.findViewById(R.id.type);

    }
}
}
