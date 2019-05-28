package com.example.mujtaba.greenteam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mujtaba on 10/13/2018.
 */

public class BowlerAdapter extends RecyclerView.Adapter<BowlerAdapter.ViewHolder> {
    private Context context;

    public BowlerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BowlerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bowling_card,parent,false);
        return new BowlerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BowlerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
