package com.example.mujtaba.greenteam;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class news extends AppCompatActivity {
    RecyclerView r1,r2;
    newsAdapter adapter;
    List<newInfo> data;
    newsAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        getSupportActionBar().hide();
        data=new ArrayList<>();

        TextView t=(TextView)findViewById(R.id.heading);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/heading1.ttf");
        t.setTypeface(custom_font);

        r1=(RecyclerView)findViewById(R.id.featureNews);
        r1.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(news.this, LinearLayoutManager.HORIZONTAL, false);
        r1.setLayoutManager(linearLayoutManager);
//        r1.setLayoutManager(new LinearLayoutManager(this));

        r2=(RecyclerView)findViewById(R.id.allNews);
        r2.setHasFixedSize(true);
        r2.setLayoutManager(new LinearLayoutManager(this));


        loadFeatureNews();
        loadAllNews();

    }

    private void loadFeatureNews() {
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/1st-match-abu-dhabi-league-1140x599.jpg","AbuDhabi Perimier leagues finish in Sheikhzaida Stadium"));
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/5-captions-approch-by-bookies.jpg","Five captains approached by bookies last year, reveals ICC"));
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/pakistan.jpg","PCB releases schedule for Pakistan’s series against Australia, New Zealand"));

        adapter= new newsAdapter(data,news.this);
        r1.setAdapter(adapter);

    }
    private void loadAllNews() {
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/1st-match-abu-dhabi-league-1140x599.jpg","AbuDhabi Perimier leagues finish in Sheikhzaida Stadium"));
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/5-captions-approch-by-bookies.jpg","Five captains approached by bookies last year, reveals ICC"));
        data.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/pakistan.jpg","PCB releases schedule for Pakistan’s series against Australia, New Zealand"));

        adapter2= new newsAdapter2(data,news.this);
        r2.setAdapter(adapter2);

    }
}
