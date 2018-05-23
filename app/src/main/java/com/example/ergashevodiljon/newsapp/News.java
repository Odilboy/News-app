package com.example.ergashevodiljon.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class News {

    @SerializedName("publishedAt")
    private String date;
    @SerializedName("urlToImage")
    private String imageUrl;
    @SerializedName("author")
    private String authorName;
    private String description;
    private String url;

    public News(String date, String imageUrl, String authorName, String description) {
        this.date = date;
        this.imageUrl = imageUrl;
        this.authorName = authorName;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
