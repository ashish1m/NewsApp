package com.example.newsapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.newsapp.db.AppDatabase;
import com.example.newsapp.db.entity.Article;
import com.example.newsapp.db.entity.Category;

import java.util.List;

public class DataRepository {
    private static DataRepository sInstance;

    private final AppDatabase mDatabase;

    private MediatorLiveData<List<Category>> mObservableCategories;

    private MediatorLiveData<List<Article>> mObservableArticles;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableCategories = new MediatorLiveData<>();

        mObservableCategories.addSource(mDatabase.categoryDao().loadAllCategories(),
                categories -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableCategories.postValue(categories);
                    }
                });

        mObservableArticles = new MediatorLiveData<>();

        mObservableArticles.addSource(mDatabase.articleDao().loadAllArticles(),
                articleEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableArticles.postValue(articleEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase appDatabase) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null)
                    sInstance = new DataRepository(appDatabase);
            }
        }

        return sInstance;
    }

    public LiveData<List<Category>> getAllCategories() {
        return mObservableCategories;
    }

    public LiveData<List<Article>> getAllArticles() {
        return mObservableArticles;
    }

    public LiveData<Article> getArticle(final int articleId) {
        return mDatabase.articleDao().loadArticle(articleId);
    }

    public LiveData<Category> getCategory(final int categoryId) {
        return mDatabase.categoryDao().loadCategory(categoryId);
    }

    public LiveData<List<Article>> getArticleByCategory(int categoryId) {
        return mDatabase.articleDao().loadArticlesByCategory(categoryId);
    }
}
