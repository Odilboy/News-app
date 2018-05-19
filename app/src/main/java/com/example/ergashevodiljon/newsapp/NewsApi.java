package com.example.ergashevodiljon.newsapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("top-headlines?country=us&category=business&apiKey=cdbeeeeed1004851afafb5dfc325a86d")
   // Call<List<News>> getNewsList(ArrayList<News> newsArrayList);
    Call<List<News>> getNewsList();
}
