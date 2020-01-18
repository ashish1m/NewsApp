package com.example.newsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.newsapp.DataRepository;
import com.example.newsapp.NewsApp;
import com.example.newsapp.repository.db.entity.Category;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<Category>> mObservableCategories;
    private final DataRepository mRepository;

    public CategoryViewModel(@NonNull Application application) {
        super(application);

        mObservableCategories = new MediatorLiveData<>();
        mObservableCategories.setValue(null);

        mRepository = ((NewsApp) application).getRepository();

        LiveData<List<Category>> categories = mRepository.getAllCategories();

        mObservableCategories.addSource(categories, mObservableCategories::setValue);
    }

    public LiveData<List<Category>> getCategories() {
        return mObservableCategories;
    }
}
