package com.tw.weatherapp.weatherappsaurabh.detail.detail

import com.tw.weatherapp.weatherappsaurabh.detail.model.WeatherInfo


interface DetailView{
        fun updateWeather(weather: WeatherInfo)
        fun showLoader()
        fun hideLoader()
        fun handleError()
    }

