package com.example.melentyev.sergey.habrahabr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.melentyev.sergey.habrahabr.url.GetRssFeeds;

public abstract class MainActivity extends AppCompatActivity implements GetRssFeeds.CallBackMethod {

    private GetRssFeeds mGetRssFeeds;
    private static final String GET_RSS_FEEDS = "GET_RSS_FEEDS";
    private static final String HABRA_RSS_URL = "https://habrahabr.ru/rss/all/";

    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        Fragment recyclerFragment = manager.findFragmentById(R.id.activity_main_id);
        if (recyclerFragment == null) {
            recyclerFragment = getFragment();
            manager.beginTransaction().add(R.id.activity_main_id, recyclerFragment, null).commit();
        }

        mGetRssFeeds = (GetRssFeeds) manager.findFragmentByTag(GET_RSS_FEEDS);
        if (mGetRssFeeds == null) {
            mGetRssFeeds = new GetRssFeeds();
            manager.beginTransaction().add(mGetRssFeeds, GET_RSS_FEEDS).commit();
        }
        mGetRssFeeds.taskToExecute(HABRA_RSS_URL);

    }

    @Override
    public void callBackMethod(String string) {
        System.out.println("!!!!!!!!!" + string);
    }

}