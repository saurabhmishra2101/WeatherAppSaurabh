package com.tw.weatherapp.weatherappsaurabh.detail.network

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tw.weatherapp.weatherappsaurabh.detail.util.APIName
import com.tw.weatherapp.weatherappsaurabh.detail.util.SingletonActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import javax.xml.transform.Result


interface WeatherService {


    fun weatherDetailAPI(url: String) {
    }



}








