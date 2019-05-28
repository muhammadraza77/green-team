package com.example.mujtaba.greenteam;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



    public class Frag2 extends Fragment {
        int c,a;
    private RecyclerView recyclerView;
            public Frag2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.frag2RecyclerVIew);

        new upcoming().execute();
    }

    public class upcoming extends AsyncTask<Void,Void,Void> {
//            private ProgressDialog mProgressDialog;
//            private String url = "http://hamariweb.com/cricket/schedules.aspx";
        private String url = "https://www.icc-cricket.com/mens-schedule/list";
            private ArrayList<String> Match_name = new ArrayList<>();
            private ArrayList<String> match_date = new ArrayList<>();
            private ArrayList<String> Match_format = new ArrayList<>();
            private ArrayList<String> Match_time = new ArrayList<>();
        private ArrayList<Boolean> Extra = new ArrayList<>();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    // Connect to the web site
                    Document mBlogDocument = Jsoup.connect(url).get();
                    // Using Elements to get the Meta data
                    Elements mElementDataSize = mBlogDocument.select("section[class=main-widget]").select("div[class=js-matchlist]").select("a");
                    // Locate the content attribute
                    c = mElementDataSize.size();
                    for (int i = 0; i < c ; i++) {
                        Elements temp =mBlogDocument.select("section[class=main-widget]").select("div[class=js-matchlist]").select("a").eq(i);
                        Elements live = temp.select("div[class=match-block__live]");

                        if (live.text().equals("Live"))Extra.add(true);
                        else Extra.add(false);

                        Elements format = temp.select("div[class=match-block__type]");
                        String mformat= format.text();
                        Elements time= temp.select("div[class=match-block__meta-container]").select("time");
                        String mtime = time.text();
                        Elements tmp = temp.select("div[class=match-block__team-container]").select("div[class=match-block__teams]");

                            Elements team1 = tmp.select("div[class=match-block__team]").eq(0);
                            String
                                    output = team1.text();
                            Elements team2 = tmp.select("div[class=match-block__team]").eq(1);
                            output= output + " V " + team2.text();


                        Match_time.add(mtime);
                        Match_format.add(mformat);
                        Match_name.add(output);
                        match_date.add("");

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
//for(int i = 0 ; i < c ; i++)
//                Toast.makeText(getContext(), "Name:- " + Match_format.get(i) +"\n Time:- "+ Match_time.get(i) + "\n team:- "+ Match_name.get(i) , Toast.LENGTH_SHORT).show();
//
                frag2Adapter mDataAdapter = new frag2Adapter( Match_name, Match_format,match_date,Match_time,Extra);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mDataAdapter);

            }
        }

    }
