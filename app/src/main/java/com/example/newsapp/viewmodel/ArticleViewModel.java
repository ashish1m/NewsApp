package com.example.newsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.newsapp.DataRepository;
import com.example.newsapp.NewsApp;
import com.example.newsapp.db.entity.Article;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<Article>> mObservableArticles;
    private final DataRepository mRepository;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        mObservableArticles = new MediatorLiveData<>();

        mObservableArticles.setValue(null);

        mRepository = ((NewsApp) application).getRepository();

        LiveData<List<Article>> articles = mRepository.getAllArticles();

        mObservableArticles.addSource(articles, mObservableArticles::setValue);
    }

    public LiveData<List<Article>> getArticles() {
        return mObservableArticles;
    }

    public LiveData<List<Article>> getArticleByCategory(int categoryId) {
        return mRepository.getArticleByCategory(categoryId);
    }
}
