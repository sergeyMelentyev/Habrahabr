package com.example.melentyev.sergey.habrahabr.url;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class GetRssFeeds extends Fragment {

    private CallBackMethod mCallBackMethod;

    public GetRssFeeds() {

    }

    public interface CallBackMethod {
        void callBackMethod(String string);
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

    private class SendRequest extends AsyncTask<String, Void, String> {
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mCallBackMethod.callBackMethod(s);
        }
        @Override
        protected String doInBackground(String... params) {
            String result = params[0];
            return result;
        }
    }
}