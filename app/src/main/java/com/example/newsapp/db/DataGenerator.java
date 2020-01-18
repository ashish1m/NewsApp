package com.example.newsapp.db;

import com.example.newsapp.NewsApp;
import com.example.newsapp.db.entity.Article;
import com.example.newsapp.db.entity.Category;
import com.example.newsapp.repository.remote.NewsService;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<Category> generateCategories() {
        List<Category> categories = new ArrayList<>();

        // Business Category
        Category businessCategory = new Category();
        businessCategory.setShortName("business");
        businessCategory.setName("Business");
        categories.add(businessCategory);

        // Entertainment Category
        Category entertainmentCategory = new Category();
        entertainmentCategory.setShortName("entertainment");
        entertainmentCategory.setName("Entertainment");
        categories.add(entertainmentCategory);

        // General Category
        Category generalCategory = new Category();
        generalCategory.setShortName("general");
        generalCategory.setName("General");
        categories.add(generalCategory);

        // Health Category
        Category healthCategory = new Category();
        healthCategory.setShortName("health");
        healthCategory.setName("Health");
        categories.add(healthCategory);

        // Science Category
        Category scienceCategory = new Category();
        scienceCategory.setShortName("science");
        scienceCategory.setName("Science");
        categories.add(scienceCategory);

        // Sports Category
        Category sportsCategory = new Category();
        sportsCategory.setShortName("sports");
        sportsCategory.setName("Sports");
        categories.add(sportsCategory);

        // Technology Category
        Category technologyCategory = new Category();
        technologyCategory.setShortName("technology");
        technologyCategory.setName("Technology");
        categories.add(technologyCategory);

        return categories;
    }
}
