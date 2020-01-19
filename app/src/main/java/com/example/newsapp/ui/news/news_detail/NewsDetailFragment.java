package com.example.newsapp.ui.news.news_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.repository.Utils;
import com.example.newsapp.repository.db.entity.Article;

import java.io.Serializable;

public class NewsDetailFragment extends Fragment implements View.OnClickListener {

    private NewsDetailViewModel mViewModel;
    private ImageView mNewsImageIv;
    private TextView mNewsTitleTv;
    private TextView mNewsDescriptionTv;
    private TextView mNewsDatePublishedTv;
    private ImageView mShareIv;
    private static final String ARTICLE_KEY = "ARTICLE";
    private Article mArticle;

    public static NewsDetailFragment newInstance(Article article) {
        NewsDetailFragment newsDetailFragment = new NewsDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARTICLE_KEY, article);
        newsDetailFragment.setArguments(bundle);
        return new NewsDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            mArticle = (Article) getArguments().getSerializable(ARTICLE_KEY);
        }
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsDetailViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void initView(View view) {
        mNewsImageIv = view.findViewById(R.id.iv_newsImage);
        mNewsTitleTv = view.findViewById(R.id.tv_title);
        mNewsDescriptionTv = view.findViewById(R.id.tv_description);
        mNewsDatePublishedTv = view.findViewById(R.id.tv_datePublished);
        mShareIv = view.findViewById(R.id.iv_share);

        mShareIv.setOnClickListener(this);
    }

    private void updateUI() {
        if (mArticle != null){
            mNewsTitleTv.setText(mArticle.getTitle());
            mNewsDescriptionTv.setText(mArticle.getDescription());
            mNewsDatePublishedTv.setText(mArticle.getPublishedTime());
            Glide.with(this)
                    .load(mArticle.getThumbUrl())
                    .centerCrop()
                    .into(mNewsImageIv);
        } else {
            Utils.showToastMessage("Unable to load news Data.");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_share:
                fireShareIntent(mArticle.getUrl());
            break;
        }
    }

    private void fireShareIntent(String urlToSend){
        ShareCompat.IntentBuilder
                .from(getActivity())
                .setType("text/plain")
                .setChooserTitle("Share URL")
                .setText(urlToSend)
                .startChooser();
    }
}
