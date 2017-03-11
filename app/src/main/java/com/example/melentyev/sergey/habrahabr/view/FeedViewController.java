package com.example.melentyev.sergey.habrahabr.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melentyev.sergey.habrahabr.R;
import com.example.melentyev.sergey.habrahabr.model.Feed;
import com.example.melentyev.sergey.habrahabr.model.FeedPool;

import java.util.UUID;

public class FeedViewController extends Fragment {

    private TextView mDate;
    private ImageView mImage;
    private TextView mTitle;
    private TextView mDescription;
    private Button mShowBtn;
    private Feed mFeed;

    public static Fragment getInstance() {
        return new FeedViewController();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID uuid = (UUID) getActivity().getIntent().getSerializableExtra(FeedViewActivity.INTENT_ID);
        mFeed = FeedPool.getFeed(uuid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_view, container, false);

        mDate = (TextView) view.findViewById(R.id.feed_view_pub_date);
        mImage = (ImageView) view.findViewById(R.id.feed_view_image);
        mTitle = (TextView) view.findViewById(R.id.feed_view_title);
        mDescription = (TextView) view.findViewById(R.id.feed_view_description);

        mTitle.setText(mFeed.getTitle());
        mDescription.setText(mFeed.getDescription());

        mShowBtn = (Button) view.findViewById(R.id.feed_view_show_btn);
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = HabraWebViewActivity.newIntent(getActivity(), mFeed.getUUID());
                startActivity(intent);
            }
        });

        return view;
    }
}