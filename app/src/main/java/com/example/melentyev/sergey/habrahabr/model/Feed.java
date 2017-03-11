package com.example.melentyev.sergey.habrahabr.model;

import android.graphics.Bitmap;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Feed {
    private String mTitle;  // cellView
    private String mLinkToFullPost; // feedView
    private String mDescription;    // feedView
    private String mCategory;   // cellView
    private Date mPubDate;
    private String mImageUrl;   // cellView
    private Bitmap mImage;  // cellView
    private UUID mUUID; // data

    public Feed(String title, String pubDate, String description, String category,
                String imageUrl, String linkToFullPost) {
        mTitle = title;
        mDescription = description;
        mCategory = category;
        mImageUrl = imageUrl;
        mLinkToFullPost = linkToFullPost;
        mUUID = UUID.randomUUID();
        mPubDate = parseReceivedDate(pubDate);
    }

    private Date parseReceivedDate(String pubDate) {
        Date date;
        DateFormat df = DateFormat.getDateInstance();
        try {
            date = df.parse(pubDate);
        } catch (ParseException e) {
            date = null;
            e.printStackTrace();
        }
        return date;
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

    public Date getPubDate() {
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

    public Bitmap getImage() {
        Bitmap image = null;
        mImage = image;
        return mImage;
    }
}