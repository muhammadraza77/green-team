package com.example.mujtaba.greenteam;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baoyz.widget.PullRefreshLayout;
import com.google.android.youtube.player.internal.m;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.mujtaba.greenteam.R.attr.layoutManager;


public class Frag1 extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private RequestQueue mQueue;
    private PullRefreshLayout layout;
    List<String> a;
    String URL_vari= "http://ams.mapps.cricbuzz.com/cbzandroid/2.0/currentmatches.json";
        private List<Live_Score> matchdata;
Handler refreshlivedata = new Handler();
    public Frag1(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        matchdata = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_1, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView)view.findViewById(R.id.frag1RecyclerView);
        layout = (PullRefreshLayout)view.findViewById(R.id.pulltorefresh);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        mQueue = Volley.newRequestQueue(getContext());
        LoadData1();
//        refreshlivedata.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                LoadData1();
//            }
//        },1000);
        layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LoadData1();
            }
        });
        layout.setRefreshing(false);
    }

    private void LoadData1() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("LOADING ......");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(0,URL_vari,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonArray = new JSONArray(response);
                    int size = jsonArray.length();
                    for (int i = 0 ; i<5 ; i++){
                        JSONObject matchdetails = jsonArray.getJSONObject(i);
                        String series = matchdetails.getString("srs");
                        String type=null,matchstate=null,toss=null,decision=null,status=null;
                        if(matchdetails.has("header")) {
                            JSONObject header = matchdetails.getJSONObject("header");
                            type = header.getString("type");
                            matchstate = header.getString("mchState");
                            toss = header.getString("TW");
                            decision = header.getString("decisn");
                            status = header.getString("status");
                        }


                        JSONObject team1 = matchdetails.getJSONObject("team1");
                        String team1name = team1.getString("name");
                        JSONObject team2 = matchdetails.getJSONObject("team2");
                        String team2name = team2.getString("name");



                        batsmen striker_batsmen=null,nonstriker_batsmen=null;bowler striker_bowler=null,nonstriker_bowler=null;
                        String t1score=null,t1over=null,t2score=null,t2over=null,runs=null,balls=null;
                        float floatruns,floatballs;
                        if(matchdetails.has("miniscore")) {
                            JSONObject score = matchdetails.getJSONObject("miniscore");
                            t1score = score.getString("batteamscore");
                            t1over = score.getString("overs");
                            t2over = score.getString("bowlteamovers");
                            t2score = score.getString("bowlteamscore");
//
                            if(score.has("striker")) {
                                JSONObject b1 = score.getJSONObject("striker");
                                 runs = b1.getString("runs");
                                balls = b1.getString("balls");
                                 floatruns = Float.parseFloat(runs);
                                floatballs = Float.parseFloat(balls);
                                float SR1 = floatruns / floatballs;
                                String sr1 = String.format("%.2f", SR1);
                                striker_batsmen = new batsmen(b1.getString("fullName"), runs, balls, b1.getString("fours"), b1.getString("sixes"), sr1);
                            }
                            if(score.has("nonStriker")) {
                                JSONObject b2 = score.getJSONObject("nonStriker");
                                runs = b2.getString("runs");
                                balls = b2.getString("balls");
//                                floatruns = Float.parseFloat(runs);
//                                floatballs = Float.parseFloat(balls);
//                                float SR2 = floatruns / floatballs;
//                                String sr2 = String.format("%.2f", SR2);
                                nonstriker_batsmen = new batsmen(b2.getString("fullName"), runs, balls, b2.getString("fours"), b2.getString("sixes"), "");
                            }
                            JSONObject bw1 = score.getJSONObject("bowler");
                             striker_bowler = new bowler(bw1.getString("fullName"), bw1.getString("overs"), bw1.getString("maidens"), bw1.getString("runs"), bw1.getString("wicket"));
                            JSONObject bw2 = score.getJSONObject("nsbowler");
                             nonstriker_bowler = new bowler(bw2.getString("fullName"), bw2.getString("overs"), bw2.getString("maidens"), bw2.getString("runs"), bw2.getString("wicket"));
                        }
//
            Live_Score temp = new Live_Score(team1name,team2name,series,type,matchstate,status,toss, decision,striker_batsmen,nonstriker_batsmen,striker_bowler,nonstriker_bowler,t1score,t1over,t2score,t2over);
                    matchdata.add(temp);
//                        Toast.makeText(getContext(), "added data for "+ i, Toast.LENGTH_SHORT).show();
                    }
                    adapter = new frag1Adapter(getContext(),matchdata);
                    recyclerView.setAdapter(adapter);
                    progressDialog.cancel();
                }catch (Exception x){

                }
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
              mQueue.add(stringRequest);

    }

}
