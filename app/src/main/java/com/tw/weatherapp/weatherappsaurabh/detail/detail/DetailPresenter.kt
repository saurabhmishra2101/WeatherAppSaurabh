package com.tw.weatherapp.weatherappsaurabh.detail.detail


import android.os.Parcel
import android.os.Parcelable
import com.tw.weatherapp.weatherappsaurabh.detail.network.WeatherService
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.internal.operators.OperatorReplay.observeOn
import rx.schedulers.Schedulers

class DetailPresenter(
        val view: DetailView,
        private val retrofitService: WeatherService,
        private val processScheduler: Scheduler = Schedulers.io(),
        private val androidScheduler: Scheduler = AndroidSchedulers.mainThread()) {

    fun onCreate() {
        view.showLoader()

       /* retrofitService.getByCityName("Bangalore")
                .subscribeOn(processScheduler)
                .observeOn(androidScheduler)
                .subscribe(
                        { weather ->
                            view.updateWeather(weather)
                            view.hideLoader()
                        },
                        { t -> view.hideLoader()
                            view.handleError()

                        })
*/
    }

}