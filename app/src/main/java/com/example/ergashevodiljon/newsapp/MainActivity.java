package com.example.ergashevodiljon.newsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    private ArrayList<News> newsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/")
                .build();
        NewsApi service = retrofit.create(NewsApi.class);
        Call<List<News>> repos = service.getNewsList(newsArrayList);
        repos.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> news = (List<News>) response.body();
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();

            }
        });





*/

        NewsApi service = RetrofitClientInstance.getRetrofitInstance().create(NewsApi.class);
        Call<List<News>> call = service.getNewsList();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();

            }
        });

      /*  recyclerView = findViewById(R.id.recyclerview1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(this, newsArrayList);
        recyclerView.setAdapter(newsAdapter); */

    }

    public void generateDataList(List<News> news)
    {
        recyclerView = findViewById(R.id.recyclerview1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter = new NewsAdapter(this, newsArrayList);
        recyclerView.setAdapter(newsAdapter);
    }
}
