package com.example.mujtaba.greenteam;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class news_fragment extends Fragment {
    private DatabaseReference mDatabase;
    RecyclerView featureRecycler,topAdapter;
    newsAdapter adapter;
    List<newInfo> data,data2;
//    https://api.myjson.com/bins/nscwc
    private newsAdapter2 adapter2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_news,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);data=new ArrayList<>();       data2=new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        featureRecycler=(RecyclerView)view.findViewById(R.id.featureNews);
        featureRecycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        featureRecycler.setLayoutManager(linearLayoutManager);

        topAdapter=(RecyclerView)view.findViewById(R.id.allNews);
        topAdapter.setHasFixedSize(true);
        topAdapter.setLayoutManager(new LinearLayoutManager(getContext()));
        topAdapter.setNestedScrollingEnabled(false);

        LoadFeature();
        LoadTop();
    }
    public void LoadFeature(){
       mDatabase.child("featured").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               List<String> keys = new ArrayList<String>();
               for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                   newInfo article = keyNode.getValue(newInfo.class);
                   data.add(article);
               }
               adapter= new newsAdapter(data,getContext());
               featureRecycler.setAdapter(adapter);
           }
           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
           }
       });

    }
    public void LoadTop(){
        mDatabase.child("top").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> keys = new ArrayList();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    newInfo article = keyNode.getValue(newInfo.class);
                    data2.add(article);
                }
                adapter2= new newsAdapter2(data2,getContext());
                topAdapter.setAdapter(adapter2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
    public void loadAllNews() {
        data2.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/1st-match-abu-dhabi-league-1140x599.jpg","AbuDhabi Perimier leagues finish in Sheikhzaida Stadium"));
        data2.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/5-captions-approch-by-bookies.jpg","Five captains approached by bookies last year, reveals ICC"));
        data2.add(new newInfo("http://sports.wegreenz.com/wp-content/uploads/2018/09/pakistan.jpg","PCB releases schedule for Pakistan’s series against Australia, New Zealand"));

        adapter2= new newsAdapter2(data2,getContext());
        topAdapter.setAdapter(adapter2);

    }

}
