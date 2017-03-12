package com.example.melentyev.sergey.habrahabr.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melentyev.sergey.habrahabr.R;
import com.example.melentyev.sergey.habrahabr.model.Feed;
import com.example.melentyev.sergey.habrahabr.model.FeedPool;
import com.example.melentyev.sergey.habrahabr.url.GetRssFeeds;

import java.util.List;

public class RecyclerViewController extends Fragment {

    private RecyclerCellViewAdapter adapter;
    private List<Feed> mFeedList;

    public static Fragment getInstance() {
        return new RecyclerViewController();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFeedList = FeedPool.getFeedList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new RecyclerCellViewAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }

    private class RecyclerCellViewAdapter extends RecyclerView.Adapter<RecyclerCellViewHolder> {

        @Override
        public RecyclerCellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new RecyclerCellViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(RecyclerCellViewHolder holder, int position) {
            Feed feed = mFeedList.get(position);
            holder.bindView(feed);
        }

        @Override
        public int getItemCount() {
            return mFeedList.size();
        }
    }

    private class RecyclerCellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImage;
        private TextView mTitle;
        private Feed mFeed;

        public RecyclerCellViewHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.recycler_cell, viewGroup, false));
            mImage = (ImageView) itemView.findViewById(R.id.recycler_view_image);
            mTitle = (TextView) itemView.findViewById(R.id.recycler_cell_title);
            itemView.setOnClickListener(this);
        }

        public void bindView(Feed feed) {
            mFeed = feed;
            //mImage.setImageBitmap(mFeed.getImage());
            mTitle.setText(mFeed.getTitle());
        }

        @Override
        public void onClick(View v) {
            Intent intent = FeedViewActivity.newIntent(getActivity(), mFeed.getUUID());
            startActivity(intent);
        }
    }
}