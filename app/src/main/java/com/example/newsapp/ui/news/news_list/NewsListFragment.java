package com.example.newsapp.ui.news.news_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.repository.Utils;
import com.example.newsapp.repository.db.entity.Article;
import com.example.newsapp.viewmodel.ArticleViewModel;

import java.util.List;

public class NewsListFragment extends Fragment implements NewsListAdapter.OnItemClickListener {

    private NewsListViewModel mViewModel;
    private RecyclerView mNewsListRv;
    private NewsListAdapter mNewsListAdapter;
    private OnNewsSelectedListener mListener;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }

    public void addOnNewsSelectedListener(OnNewsSelectedListener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNewsListAdapter = new NewsListAdapter(null);
        mNewsListAdapter.addOnItemClickListener(this);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsListViewModel.class);
        // TODO: Use the ViewModel
    }

    private void initView(View view) {
        mNewsListRv = view.findViewById(R.id.rv_newsList);
        mNewsListRv.setHasFixedSize(true);
        mNewsListRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNewsListRv.setAdapter(mNewsListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        ArticleViewModel articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        subscribeUi(articleViewModel.getArticles());
//        mNewsListAdapter.updateList(Utils.getNewsResponse().getArticles());
    }

    private void subscribeUi(LiveData<List<Article>> liveData) {
        // Update the list when the data changes
        liveData.observe(this, articles -> {
            if (articles != null) {
                //mBinding.setIsLoading(false);
                mNewsListAdapter.updateList(articles);
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
    public void onItemClick(Article article) {
        Utils.showToastMessage(article.getTitle());
        if (mListener != null) {
            mListener.onNewsSelected(article);
        }
    }

    public interface OnNewsSelectedListener {
        void onNewsSelected(Article article);
    }

}
