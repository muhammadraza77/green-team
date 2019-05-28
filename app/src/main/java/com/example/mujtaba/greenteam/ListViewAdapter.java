package com.example.mujtaba.greenteam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hong Thai
 */
public class ListViewAdapter extends ArrayAdapter<video> {

    private Activity activity;

    public ListViewAdapter(Activity activity, int resource, List<video> v) {
        super(activity, resource, v);
        this.activity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_layout, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.t1.setText(getItem(position).getTitle());
        Picasso.with(activity).load(getItem(position).getThumbnail()).fit().into(holder.thumb);

        return convertView;
    }

    private static class ViewHolder {
        private TextView t1;
        private ImageView thumb;

        public ViewHolder(View v) {
            t1 = (TextView) v.findViewById(R.id.name);
            thumb= (ImageView) v.findViewById(R.id.icon);
        }
    }
}