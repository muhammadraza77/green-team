package com.example.mujtaba.greenteam;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.github.pedrovgs.DraggablePanel;
import com.github.pedrovgs.DraggableView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;

public class Streaming extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyB8RfHGKefgB0l9gO7PFVPq7nuJzxZjc9c";
    public static final String VID = "UOr8JJsZmJo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.YTvideo_player);
        youTubePlayerView.initialize(API_KEY, this);

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        MxVideoPlayer.releaseAllVideos();
//    }
//    @Override
//    public void onBackPressed() {
//        if (MxVideoPlayer.backPress()) {
//            return;
//        }
//        super.onBackPressed();
//    }
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListner);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if (!b) youTubePlayer.cueVideo(VID);
    }

        @Override
        public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to Load Video ", Toast.LENGTH_SHORT).show();

    }
        private PlayerStateChangeListener playerStateChangeListner = new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {


        }
    };
        private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
            @Override
            public void onPlaying() {

            }

            @Override
            public void onPaused() {

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };
 }
