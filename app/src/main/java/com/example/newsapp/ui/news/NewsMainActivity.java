package com.example.newsapp.ui.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.newsapp.R;
import com.example.newsapp.repository.db.entity.Article;
import com.example.newsapp.ui.news.news_detail.NewsDetailFragment;
import com.example.newsapp.ui.news.news_list.NewsListFragment;
import com.example.newsapp.repository.db.entity.Category;
import com.example.newsapp.viewmodel.CategoryViewModel;

import java.util.List;

public class NewsMainActivity extends AppCompatActivity implements NewsListFragment.OnNewsSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);
        loadNewsListScreen();
    }

    private void loadNewsListScreen(){
        NewsListFragment newsListFragment = NewsListFragment.newInstance();
        newsListFragment.addOnNewsSelectedListener(this);
        loadFragment(newsListFragment);
    }

    private void loadNewsDetailScreen(Article article) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        newsDetailFragment.setArticle(article);
        loadFragment(newsDetailFragment);
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

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

    @Override
    public void onNewsSelected(Article article) {
        loadNewsDetailScreen(article);
    }
}
