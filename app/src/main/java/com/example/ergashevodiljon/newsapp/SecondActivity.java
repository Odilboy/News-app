package com.example.ergashevodiljon.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class SecondActivity extends AppCompatActivity{

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_news);
        webView = findViewById(R.id.web_view);
        webView.loadUrl(getIntent().getStringExtra("data"));
        webView.setWebViewClient(new MyWebViewClient(this));
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        setContentView(R.layout.activity_main);
        super.onBackPressed();
    }
}