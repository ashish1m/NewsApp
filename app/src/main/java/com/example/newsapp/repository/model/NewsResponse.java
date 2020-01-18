package com.example.newsapp.repository.model;

import com.example.newsapp.repository.db.entity.Article;

import java.util.ArrayList;


public class NewsResponse {

    private String totalResults;
    private ArrayList<Article> articles;
    private String status;

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [totalResults = " + totalResults + ", articles = " + articles + ", status = " + status + "]";
    }
}
