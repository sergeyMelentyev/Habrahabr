package com.example.melentyev.sergey.habrahabr.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import com.example.melentyev.sergey.habrahabr.MainActivity;

import java.util.UUID;

public class FeedViewActivity extends MainActivity {

    protected static final String INTENT_ID = "INTENT_ID";

    @Override
    protected Fragment getFragment() {
        return FeedViewController.getInstance();
    }

    public static Intent newIntent(Context context, UUID uuid) {
        Intent intent = new Intent(context, FeedViewActivity.class);
        intent.putExtra(INTENT_ID, uuid);
        return intent;
    }
}