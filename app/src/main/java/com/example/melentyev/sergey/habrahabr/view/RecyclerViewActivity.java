package com.example.melentyev.sergey.habrahabr.view;

import android.support.v4.app.Fragment;
import com.example.melentyev.sergey.habrahabr.MainActivity;

public class RecyclerViewActivity extends MainActivity {

    @Override
    protected Fragment getFragment() {
        return RecyclerViewController.getInstance();
    }

}