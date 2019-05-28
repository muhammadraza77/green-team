package com.example.mujtaba.greenteam;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class testFrag extends Fragment {


    public testFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MxVideoPlayerWidget videoPlayerWidget = (MxVideoPlayerWidget) view.findViewById(R.id.mpw_video_player);
        videoPlayerWidget.startPlay("https://www.facebook.com/cricingif/videos/173146570300320/", MxVideoPlayer.SCREEN_LAYOUT_NORMAL,"Video Title");

    }
}
