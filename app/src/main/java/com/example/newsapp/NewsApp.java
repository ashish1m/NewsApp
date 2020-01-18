package com.example.newsapp;

import android.app.Application;

import com.example.newsapp.db.AppDatabase;
import com.example.newsapp.repository.remote.Api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApp extends Application {

    private static NewsApp mInstance;
    private Retrofit mRetrofit;
    private AppExecutors mAppExecutors;

    public static NewsApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        mAppExecutors = new AppExecutors();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("X-API-Key", Api.apiKey)
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                })
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
