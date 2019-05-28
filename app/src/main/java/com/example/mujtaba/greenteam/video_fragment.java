package com.example.mujtaba.greenteam;
//http://www.devexchanges.info/2015/06/create-draggable-panel-like-youtube-in.html

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pedrovgs.DraggablePanel;
import com.github.pedrovgs.DraggableView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class video_fragment extends Fragment {
//    private RecyclerView videoRecycler;
    private ListView listview;
//    private videoAdapter adapter;
    private ListViewAdapter adapter;
    private DatabaseReference mDatabase;
    public static List<video> vdata;
    public static DraggableView draggableView;
    private TextView title , desc;
    private LinearLayout lr1;

        Handler c = new Handler ();
    public static final String API_KEY = "AIzaSyB8RfHGKefgB0l9gO7PFVPq7nuJzxZjc9c";
    public static String VID = "3Bn6TCxj99U";
    private YouTubePlayer yt;
    private YouTubePlayerSupportFragment youTubePlayerFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable  ViewGroup container,@Nullable Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        vdata = new ArrayList<>();

        youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube, youTubePlayerFragment).commit();
        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {

                    yt = player;
                    yt.loadVideo("2zNSgSzhBfM");
                    yt.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                // TODO Auto-generated method stub

            }
        });
        return inflater.inflate(R.layout.video_fragment, container, false);
    }    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        videoRecycler=(RecyclerView)view.findViewById(R.id.videoRV);
//        videoRecycler.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        videoRecycler.setLayoutManager(linearLayoutManager);

        title = (TextView) view.findViewById(R.id.video_title);
        desc = (TextView) view.findViewById(R.id.video_description);
        listview = (ListView) view.findViewById(R.id.videoRV);
        draggableView = (DraggableView) view.findViewById(R.id.mydraggable_view);
        lr1 = (LinearLayout) view.findViewById(R.id.lr1);
        draggableView.setVisibility(View.GONE);
        draggableView.setClickToMaximizeEnabled(true);
        listview.setOnItemClickListener(onItemClickListener());
        LoadVideos();
    }


    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
                draggableView.setVisibility(View.VISIBLE);
                if(!draggableView.isClosed() || !draggableView.isClosedAtLeft()){
                    draggableView.minimize();
                }
                draggableView.maximize();
                lr1.setBackgroundColor(getResources().getColor(R.color.white));
                title.setText(vdata.get(position).getTitle());
                desc.setText(vdata.get(position).getDescription());
                if (youTubePlayerFragment != null && yt != null) {
                    Toast.makeText(getContext(), "Here", Toast.LENGTH_SHORT).show();
                    yt.cueVideo(vdata.get(position).getId());
                }
//                YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
//                youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//
//                    @Override
//                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//                       yt= player;
//                        if (!wasRestored) {
//                            VID = vdata.get(position).getId();
//                            yt.cueVideo(VID);
//                        }
//
//                    }
//
//                    @Override
//                    public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
//                    }
//                });
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                transaction.add(R.id.youtube, youTubePlayerFragment).commit();
//                title.setText(vdata.get(position).getTitle());
//                desc.setText(vdata.get(position).getDescription());
            }
        };
    }

    public void LoadVideos(){
        mDatabase.child("videos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> keys = new ArrayList<String>();
                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    video v = keyNode.getValue(video.class);
                    vdata.add(v);
                }
//                adapter = new videoAdapter(vdata,getContext());
                adapter = new ListViewAdapter(getActivity(), R.layout.list_layout, vdata);
                listview.setAdapter(adapter);
//                videoRecycler.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
}
