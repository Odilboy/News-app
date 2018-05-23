package com.example.ergashevodiljon.newsapp;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient{

    private Context context;

    public MyWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        return super.shouldOverrideUrlLoading(view, url);
    }


}
