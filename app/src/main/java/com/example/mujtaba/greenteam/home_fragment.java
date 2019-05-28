package com.example.mujtaba.greenteam;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.special.ResideMenu.ResideMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import static com.example.mujtaba.greenteam.home.con;


public class home_fragment extends Fragment {
    ResideMenu resideMenu;
private int check=3;
    private DatabaseReference mDatabase;
    private RecyclerView rc,ranking,news;
    private scoreAdapter adapter;
    private newsAdapter3 adapter1;
    private List<newInfo> data;
    private List<score> data1;
    private ViewPager viewPager;
    private Button btn;
    private ProgressBar pb;
    public  String URL_ranking = "https://www.icc-cricket.com/rankings/mens/team-rankings/test";
    String URL_livematch= "http://ams.mapps.cricbuzz.com/cbzandroid/2.0/currentmatches.json";

    private TextView rankingtext;

    private RequestQueue mQueue;

    Handler livescorehandler = new Handler();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_frag,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pb= (ProgressBar) view.findViewById(R.id.progress);
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        rc=(RecyclerView)view.findViewById(R.id.liveScore);
        btn = (Button)view.findViewById(R.id.menu);
        rc.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rc.setLayoutManager(linearLayoutManager);
        rankingtext = (TextView)view.findViewById(R.id.rankingtextview);
        ranking=(RecyclerView)view.findViewById(R.id.homenews);
        ranking.setHasFixedSize(true);
        ranking.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        news=(RecyclerView)view.findViewById(R.id.newrv);
        news.setHasFixedSize(true);
        news.setNestedScrollingEnabled(false);
        news.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        data= new ArrayList<>();
        data1= new ArrayList<>();
        mQueue = Volley.newRequestQueue(getContext());


        new Ranking().execute();
        livescorehandler.post(new Runnable() {
            @Override
            public void run() {
                loadLiveScore();

            }
        });
        loadNews();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getActivity(), btn);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.ranking_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if ( item.getItemId()==R.id.odi){
                            if(check!=1) {
                                URL_ranking = "https://www.icc-cricket.com/rankings/mens/team-rankings/odi";
                                new Ranking().execute();check=1;
                            }
                        }
                        else if ( item.getItemId()==R.id.t20){
                            if(check!=2) {
                                URL_ranking = "https://www.icc-cricket.com/rankings/mens/team-rankings/t20i";
                                new Ranking().execute();check=2;
                            }
                        }
                        else if (item.getItemId()==R.id.test){
                            if(check!=3) {
                                URL_ranking = "https://www.icc-cricket.com/rankings/mens/team-rankings/test";
                                new Ranking().execute();check=3;
                            }
                        }
                        rankingtext.setText("Top 10 "+ item.getTitle()+" Teams");
                        return true;
                    }
                });
                popup.show(); //showing popup menu
            }
        });

    }

    public class Mytimer extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    }
                }
            });
        }
    }

    private void loadLiveScore() {
        StringRequest stringRequest = new StringRequest(0,URL_livematch,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0 ; i<2 ; i++){
                        JSONObject matchdetails = jsonArray.getJSONObject(i);
                        String series = matchdetails.getString("srs");

                        JSONObject header = matchdetails.getJSONObject("header");

                        String type= header.getString("type");
//                        String matchstate = header.getString("mchState");
                        String toss = header.getString("TW");
//                        String decision = header.getString("decisn");
//                        String status = header.getString("status");

                        JSONObject team1 = matchdetails.getJSONObject("team1");
                        String team1name = team1.getString("name");
                        JSONObject team2 = matchdetails.getJSONObject("team2");
                        String team2name = team2.getString("name");
                        String t1score=null,t1over=null,t2score=null,t2over=null;
                        if(matchdetails.has("miniscore")) {
                            JSONObject score = matchdetails.getJSONObject("miniscore");
                            t1score = score.getString("batteamscore");
                            t1over = score.getString("overs");
                            t2over = score.getString("bowlteamovers");
                            t2score = score.getString("bowlteamscore");
                        }

                        score temp = new score(series,team1name,team2name,t1score,t2score,t1over,t2over,toss);
                        data1.add(temp);
                    }
                    adapter=new scoreAdapter(data1,getContext());
                    rc.setAdapter(adapter);
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

    private void loadNews() {
            mDatabase.child("featured").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    List<String> keys = new ArrayList<String>();
                    for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                        keys.add(keyNode.getKey());
                        newInfo article = keyNode.getValue(newInfo.class);
                        data.add(article);
                    }
                    adapter1= new newsAdapter3(data,getContext());
                    news.setAdapter(adapter1);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });


    }

    public class Ranking extends AsyncTask<Void,Void,Void> {
        private ProgressDialog mProgressDialog;
        private ArrayList<String> Team_name= new ArrayList<>();
        private ArrayList<String> Points = new ArrayList<>();
        private ArrayList<String> Rating = new ArrayList<>();
        private ArrayList<String> Position = new ArrayList<>();


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document mBlogDocument = Jsoup.connect(URL_ranking).get();
                // Using Elements to get the Meta data

                Elements mElementDataSize = mBlogDocument.select("table[class=table]").select("tbody").select("tr[class=table-body]");

                int mElementSize = mElementDataSize.size()*5;

                for (int i = 0; i < 51; i++) {
                    Elements temp = mBlogDocument.select("table[class=table]").select("tbody").select("tr").select("td");

                    Elements pos = temp.eq(i);
                    String pos1 = pos.text();
                    i++;
                    Elements team = temp.eq(i);
                    String team1 = team.text();
                    i+=2;
                    Elements point = temp.eq(i);
                    String point1 = point.text();
                    i++;
                    Elements rating = temp.eq(i);
                    String rating1= rating.text();

                    Team_name.add(team1);
                    Points.add(point1);
                    Position.add(pos1);
                    Rating.add(rating1);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {

            RankingAdapter mDataAdapter = new RankingAdapter(Team_name, Rating);
            ranking.setAdapter(mDataAdapter);
//            mProgressDialog.dismiss();
            pb.setVisibility(ProgressBar.INVISIBLE);
        }

    }
}
