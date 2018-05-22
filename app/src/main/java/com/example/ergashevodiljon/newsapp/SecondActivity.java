package com.example.ergashevodiljon.newsapp;

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
}
