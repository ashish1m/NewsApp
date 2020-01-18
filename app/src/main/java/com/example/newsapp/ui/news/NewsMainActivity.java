package com.example.newsapp.ui.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.newsapp.NewsApp;
import com.example.newsapp.R;
import com.example.newsapp.db.entity.Category;
import com.example.newsapp.viewmodel.CategoryViewModel;

import java.util.List;

public class NewsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);

        CategoryViewModel categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        subscribeUi(categoryViewModel.getCategories());
    }

    private void subscribeUi(LiveData<List<Category>> liveData) {
        // Update the list when the data changes
        liveData.observe(this, categories -> {
            if (categories != null) {
                //mBinding.setIsLoading(false);
//                mProductAdapter.setProductList(myProducts);
            } else {
//                mBinding.setIsLoading(true);
            }
            // espresso does not know how to wait for data binding's loop so we execute changes
            // sync.
//            mBinding.executePendingBindings();
        });
    }
}
