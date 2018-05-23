package com.example.ergashevodiljon.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NewsAdapter.ItemClickListener{

    RecyclerView recyclerView;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsApi service = RetrofitClientInstance.getRetrofitInstance().create(NewsApi.class);
        Call<NewsResponse> call = service.getNewsList();
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                initRecycleView(newsResponse.newsList);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getMessage());

            }
        });


    }
    @Override
    public void onItemClick(View view, int position) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("data", newsAdapter.getUrl(position));
        startActivity(i);
        setContentView(R.layout.read_news);

    }

    private void initRecycleView(ArrayList<News> news)
    {
        recyclerView = findViewById(R.id.recyclerview1);
        newsAdapter = new NewsAdapter(this, news);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setClickListener(this);
    }
}
