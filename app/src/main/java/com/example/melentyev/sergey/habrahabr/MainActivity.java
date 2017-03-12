package com.example.melentyev.sergey.habrahabr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.melentyev.sergey.habrahabr.model.FeedPool;

public abstract class MainActivity extends AppCompatActivity {

    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FeedPool.getInstance(this);

        FragmentManager manager = getSupportFragmentManager();
        Fragment recyclerFragment = manager.findFragmentById(R.id.activity_main_id);
        if (recyclerFragment == null) {
            recyclerFragment = getFragment();
            manager.beginTransaction().add(R.id.activity_main_id, recyclerFragment, null).commit();
        }
    }

}