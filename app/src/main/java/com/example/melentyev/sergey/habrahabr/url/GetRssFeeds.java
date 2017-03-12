package com.example.melentyev.sergey.habrahabr.url;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.melentyev.sergey.habrahabr.model.FeedParser;

import java.io.IOException;

public class GetRssFeeds extends Fragment {

    private CallBackMethod mCallBackMethod;

    public GetRssFeeds() {

    }

    public interface CallBackMethod {
        void callBackMethod();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof CallBackMethod)) throw new AssertionError();
        mCallBackMethod = (CallBackMethod) context;
    }

    public void taskToExecute(String url) {
        SendRequest request = new SendRequest();
        request.execute(url);
    }

    private class SendRequest extends AsyncTask<String, Void, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallBackMethod.callBackMethod();
        }
        @Override
        protected Void doInBackground(String... params) {
            try {
                String result = new UrlFetcher().getUrlString(params[0]);
                FeedParser.xmlParser(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}