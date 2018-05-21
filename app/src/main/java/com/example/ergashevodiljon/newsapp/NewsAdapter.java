package com.example.ergashevodiljon.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context context;
    private ArrayList<News> newsArrayList;
    private LayoutInflater mInflater;
    News news;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = newsArrayList.get(position);

        holder.date.setText(news.getDate());
        holder.author.setText(news.getAuthorName());
        holder.description.setText(news.getDescription());
        Glide.with(context).load(news.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.description)
        TextView description;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
