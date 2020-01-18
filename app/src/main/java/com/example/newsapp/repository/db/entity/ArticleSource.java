package com.example.newsapp.repository.db.entity;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;

//@Entity(tableName = "source")
public class ArticleSource {
    @Expose
    private String id;

    @Expose
    private String name;
}
