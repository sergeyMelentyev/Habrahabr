package com.example.melentyev.sergey.habrahabr.model;

import java.util.UUID;

public class Feed {
    private String mTitle;
    private String mLinkToFullPost;
    private String mDescription;
    private String mPubDate;
    private String mImageUrl;
    private String mAuthor;
    private UUID mUUID;

    public Feed(String title, String pubDate, String description,
                String author, String imageUrl, String linkToFullPost) {
        mTitle = title;
        mPubDate = pubDate;
        mDescription = description;
        mAuthor = author;
        mImageUrl = imageUrl;
        mLinkToFullPost = linkToFullPost;
        mUUID = UUID.randomUUID();
    }
}