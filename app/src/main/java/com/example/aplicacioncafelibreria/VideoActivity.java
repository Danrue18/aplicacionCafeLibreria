package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    WebView webVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        webVideo = findViewById(R.id.webVideo);

        WebSettings settings = webVideo.getSettings();
        settings.setJavaScriptEnabled(true);

        String url = "https://www.youtube.com/embed/dQw4w9WgXcQ"; // reemplaza por tu video

        webVideo.loadUrl(url);

        findViewById(R.id.btnVolver).setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));
    }
}