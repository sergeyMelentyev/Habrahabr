package com.example.melentyev.sergey.habrahabr.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.melentyev.sergey.habrahabr.MainActivity;

import java.util.UUID;

public class HabraWebViewActivity extends MainActivity {

    public static final String WEB_INTENT_ID = "WEB_INTENT_ID";

    @Override
    protected Fragment getFragment() {
        return HabraWebViewController.getInstance();
    }

    public static Intent newIntent(Context context, UUID uuid){
        Intent intent = new Intent(context, HabraWebViewActivity.class);
        intent.putExtra(WEB_INTENT_ID, uuid);
        return intent;
    }
}
