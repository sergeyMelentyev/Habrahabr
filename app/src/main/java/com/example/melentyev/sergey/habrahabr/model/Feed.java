package com.example.melentyev.sergey.habrahabr.model;

import android.graphics.Bitmap;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

public class Feed {
    private String mTitle;
    private String mLinkToFullPost;
    private String mDescription;
    private String mCategory;
    private String mPubDate;
    private String mImageUrl;
    private Bitmap mImage;
    private UUID mUUID;

    Feed() {
        mUUID = UUID.randomUUID();
    }

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }

    public String getLinkToFullPost() {
        return mLinkToFullPost;
    }
    public void setLinkToFullPost(String linkToFullPost) {
        mLinkToFullPost = linkToFullPost;
    }

    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        mDescription = description;
    }

    public String getCategory() {
        return mCategory;
    }
    public void setCategory(String category) {
        mCategory = category;
    }

    public String getPubDate() {
        return mPubDate;
    }
    public void setPubDate(String pubDate) {
        mPubDate = pubDate;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public Bitmap getImage() {
        return mImage;
    }
    public void setImage(Bitmap image) {
        mImage = image;
    }

    public UUID getUUID() {
        return mUUID;
    }

}
