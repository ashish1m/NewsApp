package com.example.newsapp.ui.news.news_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.repository.model.Articles;

import java.util.ArrayList;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {


    private ArrayList<Articles> mArticleList;
    private OnItemClickListener mListener;

    public NewsListAdapter(ArrayList<Articles> articleList) {
        mArticleList = articleList;
    }

    public void updateList(ArrayList<Articles> articleList) {
        mArticleList = articleList;
        notifyDataSetChanged();
    }

    public void addOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Articles article = mArticleList.get(position);

        holder.mNewsTitleTv.setText(article.getTitle());
        holder.mNewsDescriptionTv.setText(article.getDescription());
        Glide.with(holder.itemView)
                .load(article.getUrlToImage())
                .centerCrop()
                .into(holder.mNewsImageIv);

        holder.mMainLayoutCv.setTag(article);
    }

    @Override
    public int getItemCount() {
        if (mArticleList != null) {
            return mArticleList.size();
        }
        return 0;
    }

    interface OnItemClickListener {
        void onItemClick(Articles article);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mNewsImageIv;
        TextView mNewsTitleTv;
        TextView mNewsDescriptionTv;
        CardView mMainLayoutCv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNewsImageIv = itemView.findViewById(R.id.iv_newsImage);
            mNewsTitleTv = itemView.findViewById(R.id.tv_title);
            mNewsDescriptionTv = itemView.findViewById(R.id.tv_description);
            mMainLayoutCv = itemView.findViewById(R.id.cv_mainLayout);

            mMainLayoutCv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cv_mainLayout:
                    if (mListener !=null){
                        mListener.onItemClick((Articles) v.getTag());
                    }
                    break;
            }
        }
    }
}
