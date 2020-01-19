/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.newsapp.repository.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.newsapp.AppExecutors;
import com.example.newsapp.NewsApp;
import com.example.newsapp.repository.db.converter.CategoryConverter;
import com.example.newsapp.repository.db.dao.ArticleDao;
import com.example.newsapp.repository.db.dao.CategoryDao;
import com.example.newsapp.repository.db.entity.Article;
import com.example.newsapp.repository.db.entity.Category;
import com.example.newsapp.repository.model.NewsResponse;
import com.example.newsapp.repository.remote.NewsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Database(entities = {Article.class, Category.class}, version = 1)
@TypeConverters(CategoryConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "news.db";

    public abstract CategoryDao categoryDao();

    public abstract ArticleDao articleDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        insertLatestArticles();
                    }

                    private void insertLatestArticles() {
                        NewsService newsService = NewsApp.getInstance().getRetrofit().create(NewsService.class);

                        Call<NewsResponse> call = newsService.getTopHeadlines("us", "general");

                        call.enqueue(new retrofit2.Callback<NewsResponse>() {
                            @Override
                            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                                if (response.isSuccessful() && response.body() != null) {

                                    executors.diskIO().execute(() -> {
                                        // Generate the data for pre-population
                                        AppDatabase database = AppDatabase.getInstance(appContext, executors);

                                        List<Category> categories = DataGenerator.generateCategories();
                                        insertData(database, categories, response.body().getArticles());
                                        // notify that the database was created and it's ready to be used
                                        database.setDatabaseCreated();
                                    });
                                }
                            }

                            @Override
                            public void onFailure(Call<NewsResponse> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                })
                .build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<Category> categories, final List<Article> articles) {
        database.runInTransaction(() -> {
            database.categoryDao().insertAll(categories);
            database.articleDao().insertAll(articles);
        });
    }

    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }
}
