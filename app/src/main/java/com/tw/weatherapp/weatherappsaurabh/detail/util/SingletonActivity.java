package com.tw.weatherapp.weatherappsaurabh.detail.util;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class SingletonActivity extends Application {

    public static  SingletonActivity  _sInstane=null;
    Context context;



    private RequestQueue mRequestQueue;
    public static final String TAG = SingletonActivity.class.getSimpleName();



    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        _sInstane=this;

    }
    public static SingletonActivity getInstance() {

        if(_sInstane==null)
        {
        }
        return _sInstane;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);




    }

    public static void showLoader(Context context) {
        ProgressDialog pdia = new ProgressDialog(getInstance());
        pdia.setMessage("Fetching Weather Information...");
        pdia.setCanceledOnTouchOutside(false);
        pdia.setCancelable(false);
        pdia.show();
    }

    public static void hideLoader(Context context) {
        ProgressDialog pdia = new ProgressDialog(getInstance());
        pdia.dismiss();
    }

}
