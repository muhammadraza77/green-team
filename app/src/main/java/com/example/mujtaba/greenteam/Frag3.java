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


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag3 extends Fragment {
    private static RecyclerView mRecyclerView;

    public Frag3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.frag3Rv);
        new Desc().execute();
    }

    public class Desc extends AsyncTask<Void,Void,Void> {
//        private ProgressDialog mProgressDialog;
        private String url = "http://hamariweb.com/cricket/results.aspx";
        private ArrayList<String> Match_name = new ArrayList<>();
        private ArrayList<String> match_date = new ArrayList<>();
        private ArrayList<String> Series_Name = new ArrayList<>();
        private ArrayList<String> Match_result = new ArrayList<>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

//            mProgressDialog = new ProgressDialog(getContext());
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document mBlogDocument = Jsoup.connect(url).get();
                // Using Elements to get the Meta data
                Elements mElementDataSize = mBlogDocument.select("table[id=PageContent_dlFixtures]").select("td").select("a[class=TextClass]");
                // Locate the content attribute
                int mElementSize = mElementDataSize.size();
                for (int i = 0; i < mElementSize; i++) {
                    Elements temp =mBlogDocument.select("table[id=PageContent_dlFixtures]");
                    //MATCH KIS KIS K BEECH HAI ENGLAND VS Srilanka
                    Elements match = temp.select("td").select("a[class=TextClass]").eq(i);
                    String matchname = match.text();
                    //Match series ka name England TOur of Srilanka
                    Elements series= temp.select("td").select("a[class=VpLink]").eq(i);
                    String series_type = series.text();

                    Elements date =temp.select("td[class=TextClass][style=padding-left: 10px]").select("span").eq(i);
                    String matchdate = date.text();

                    Elements result = temp.select("td[class=TextClass]").select("span[style=color:Blue]").eq(i);
                    String matchresult= result.text();


                    Match_name.add(matchname);
                    match_date.add(matchdate);
                    Series_Name.add(series_type);
                    Match_result.add(matchresult);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView


            frag3Adapter mDataAdapter = new frag3Adapter( Match_name, match_date,Series_Name,Match_result);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mDataAdapter);
//            mProgressDialog.dismiss();
        }
    }

}
