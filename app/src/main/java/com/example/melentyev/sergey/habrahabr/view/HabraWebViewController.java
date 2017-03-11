package com.example.melentyev.sergey.habrahabr.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.melentyev.sergey.habrahabr.R;
import com.example.melentyev.sergey.habrahabr.model.Feed;
import com.example.melentyev.sergey.habrahabr.model.FeedPool;

import java.util.UUID;

public class HabraWebViewController extends Fragment {

    private TextView mTextView;
    private Feed mFeed;

    public static Fragment getInstance(){
        return new HabraWebViewController();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID uuid = (UUID) getActivity().getIntent().getSerializableExtra(HabraWebViewActivity.WEB_INTENT_ID);
        mFeed = FeedPool.getFeed(uuid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.habra_web_view, container, false);
        mTextView = (TextView) view.findViewById(R.id.habra_wev_view_text);
        mTextView.setText(mFeed.getTitle());

        return view;
    }
}