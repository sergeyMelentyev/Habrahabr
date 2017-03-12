package com.example.melentyev.sergey.habrahabr.url;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class GetDataFromRss extends Fragment {

    private CallBackMethod mCallBackMethod;

    public GetDataFromRss() {

    }

    public interface CallBackMethod {
        void callBackMethod(String string);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }
}