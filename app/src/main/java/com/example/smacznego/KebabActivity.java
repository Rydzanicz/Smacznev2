package com.example.smacznego;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class KebabActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebab);


        setContentView(R.layout.activity_kebab);
        videoView = (VideoView) findViewById(R.id.videoView);
        String vide= "android.resource://com.example.smacznego/"+R.raw.video;
        Uri uir = Uri.parse(vide);
        videoView.setVideoURI(uir);
        MediaController mediaController= new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

}


