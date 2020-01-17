package com.example.newsapp.repository.remote;

import com.example.newsapp.repository.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    String TOP_HEADLINES = "top-headlines";
    String EVERYTHING = "everything";
    String SOURCES = "sources";

    @GET(TOP_HEADLINES)
    Call<NewsResponse> getTopHeadlines(@Query("country") String country, @Query("category") String category);

    @GET(EVERYTHING)
    Call<NewsResponse> getEverything(@Query("country") String country, @Query("category") String category);

    @GET(SOURCES)
    Call<NewsResponse> getSources(@Query("country") String country, @Query("category") String category);
}
