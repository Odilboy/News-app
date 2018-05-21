package com.example.ergashevodiljon.newsapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("v2/top-headlines?country=us&apiKey=cdbeeeeed1004851afafb5dfc325a86d")
    Call<NewsResponse> getNewsList();
}
