package com.example.melentyev.sergey.habrahabr.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FeedPool {
    private static FeedPool sFeedPool;
    private static List<Feed> mFeedList;

    private FeedPool(Context context) {
        mFeedList = new ArrayList<>();
    }

    public static FeedPool getInstanse(Context context) {
        if (mFeedList == null)
            return sFeedPool = new FeedPool(context);
        return sFeedPool;
    }

    public static List<Feed> getFeedList() {
        return mFeedList;
    }

    public static Feed getFeed(UUID uuid) {
        for (Feed feed : mFeedList)
            if (feed.getUUID().equals(uuid))
                return feed;
        return null;
    }

    public static void addFeed(Feed feed) {
        mFeedList.add(feed);
    }

}