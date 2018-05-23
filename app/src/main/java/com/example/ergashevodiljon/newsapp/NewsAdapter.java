package com.example.ergashevodiljon.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private Context context;
    private ArrayList<News> newsArrayList;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
        mInflater = LayoutInflater.from(context);

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

        holder.date.setText(news.getDate().substring(0, 10));
        if (news.getAuthorName() != null && news.getAuthorName().length() > 32) {
            holder.author.setText(news.getAuthorName().substring(0, 32));
        } else {
            holder.author.setText(news.getAuthorName());
        }
        if(news.getDescription() != null && news.getDescription().length()>80){
            holder.description.setText(news.getDescription().substring(0, 80));
        } else {
            holder.description.setText(news.getDescription());
        }
        Glide.with(context).load(news.getImageUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public String getUrl(int position) {

        return newsArrayList.get(position).getUrl();

    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
