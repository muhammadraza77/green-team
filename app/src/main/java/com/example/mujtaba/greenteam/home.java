package com.example.mujtaba.greenteam;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;

public class home extends AppCompatActivity {

    List<newInfo> data;
    public static Context con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        con = home.this;

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new home_fragment()).commit();
        BottomNavigationView bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f=null;
                switch (item.getItemId()){
                    case R.id.home:
                        f=new home_fragment();
                        break;
                    case R.id.newsid:
                        f=new news_fragment();
                        break;
                    case R.id.liveScoreid:
                        f=new Livescore_fragment();
                        break;
                    case R.id.streaming:
                        f=new video_fragment();
                        break;
                    case R.id.aboutUs:
                        f=new About_fragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,f).commit();
                return true;
            }
        });


    }
}
