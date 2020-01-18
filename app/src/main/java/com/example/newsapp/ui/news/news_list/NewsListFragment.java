package com.example.newsapp.ui.news.news_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.repository.Utils;
import com.example.newsapp.repository.model.Articles;

public class NewsListFragment extends Fragment implements NewsListAdapter.OnItemClickListener {

    private NewsListViewModel mViewModel;
    private RecyclerView mNewsListRv;
    private NewsListAdapter mNewsListAdapter;

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
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
        mNewsListAdapter.updateList(Utils.getNewsResponse().getArticles());
    }

    @Override
    public void onItemClick(Articles article) {
        Utils.showToastMessage(article.getTitle());
    }
}
