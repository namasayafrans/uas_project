package com.hello;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        // Get the video URI from the intent
        String videoPath = getIntent().getStringExtra("VIDEO_PATH");
        Uri uri = Uri.parse(videoPath);

        // Set up VideoView
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(uri);

        // Set up MediaController
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Start playing the video
        videoView.start();
    }
}