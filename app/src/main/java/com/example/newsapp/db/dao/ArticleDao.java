package com.example.newsapp.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.newsapp.db.entity.Article;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM articles ORDER BY published_time DESC")
    LiveData<List<Article>> loadAllArticles();

    @Query("SELECT * FROM articles WHERE category_id = :categoryId ORDER BY published_time DESC")
    LiveData<List<Article>> loadArticlesByCategory(int categoryId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Article> articles);

    @Query("SELECT * FROM articles WHERE id = :articleId")
    LiveData<Article> loadArticle(int articleId);
}
