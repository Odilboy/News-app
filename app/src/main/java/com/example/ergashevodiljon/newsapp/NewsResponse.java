package com.example.ergashevodiljon.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewsResponse {
    @SerializedName("status")
    String status;
    @SerializedName("articles")
    ArrayList<News> newsList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
    }
}
