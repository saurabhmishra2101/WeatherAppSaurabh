package com.tw.weatherapp.weatherappsaurabh.detail.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tw.weatherapp.weatherappsaurabh.R;
import com.tw.weatherapp.weatherappsaurabh.detail.util.SingletonActivity;

public class WeatherListActivity extends AppCompatActivity{
    TextView blrtxt,deltxt,mumtxt;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_list);

        blrtxt = (TextView)findViewById(R.id.blrtxt);
        deltxt = (TextView)findViewById(R.id.deltxt);
        mumtxt = (TextView)findViewById(R.id.mumtxt);

        blrtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(WeatherListActivity.this, WeatherDetailActivity.class);
                SingletonActivity.city = "Bangalore";
                startActivity(intent);
            }
        });

        deltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(WeatherListActivity.this, WeatherDetailActivity.class);
                SingletonActivity.city = "Delhi";
                startActivity(intent);
            }
        });

        mumtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WeatherListActivity.this, WeatherDetailActivity.class);
                SingletonActivity.city = "Mumbai";
                startActivity(intent);
            }
        });

    }
}
