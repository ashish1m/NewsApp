package com.example.newsapp.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.R;
import com.example.newsapp.ui.news_list_screen.NewsListActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToNewsListActivity();
            }
        }, 3000);
    }

    private void navigateToNewsListActivity() {
        Intent intent = new Intent(SplashActivity.this, NewsListActivity.class);
        startActivity(intent);
        finish();
    }
}
