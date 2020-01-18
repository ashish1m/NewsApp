package com.example.newsapp.repository.db.converter;

import androidx.lifecycle.LiveData;
import androidx.room.TypeConverter;

import com.example.newsapp.DataRepository;
import com.example.newsapp.NewsApp;
import com.example.newsapp.repository.db.entity.Category;

public class CategoryConverter {
    @TypeConverter
    public static Category toCategory(int categoryId) {
        LiveData<Category> category = DataRepository.getInstance(NewsApp.getInstance().getDatabase()).getCategory(categoryId);
        return categoryId > 0 ? category.getValue() : null;
    }

    @TypeConverter
    public static int toCategoryId(Category category) {
        return category != null ? category.getId() : -1;
    }
}
