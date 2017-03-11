package com.example.melentyev.sergey.habrahabr.model;

import java.util.UUID;

public class Feed {
    private String mTitle;
    private String mLinkToFullPost;
    private String mDescription;
    private String mCategory;
    private String mPubDate;
    private String mImageUrl;
    private String mAuthor;
    private UUID mUUID;

    public Feed(String title, String pubDate, String description, String category,
                String author, String imageUrl, String linkToFullPost) {
        mTitle = title;
        mPubDate = pubDate;
        mDescription = description;
        mCategory = category;
        mAuthor = author;
        mImageUrl = imageUrl;
        mLinkToFullPost = linkToFullPost;
        mUUID = UUID.randomUUID();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getLinkToFullPost() {
        return mLinkToFullPost;
    }

    public String getPubDate() {
        return mPubDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }

    public UUID getUUID() {
        return mUUID;
    }
}