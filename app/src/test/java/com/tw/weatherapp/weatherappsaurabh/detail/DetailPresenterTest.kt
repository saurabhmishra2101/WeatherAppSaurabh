package com.tw.weatherapp.weatherappsaurabh.detail





import com.nhaarman.mockito_kotlin.mock
import com.tw.weatherapp.weatherappsaurabh.detail.detail.DetailPresenter
import com.tw.weatherapp.weatherappsaurabh.detail.detail.DetailView
import com.tw.weatherapp.weatherappsaurabh.detail.model.Main
import com.tw.weatherapp.weatherappsaurabh.detail.model.WeatherInfo
import com.tw.weatherapp.weatherappsaurabh.detail.model.Wind
import com.tw.weatherapp.weatherappsaurabh.detail.network.WeatherService

import org.junit.Before
import org.junit.Test
import org.mockito.Matchers.eq
import org.mockito.Mockito.*
import rx.Observable
import rx.schedulers.TestScheduler


@Suppress("DEPRECATION")
class DetailPresenterTest {


    private val weatherInfo: WeatherInfo
        get() = WeatherInfo(ArrayList(), Main(2.0, 1, 1, 2.0, 2.0), Wind(2.0, 1), 1, 1, "Bng")
    lateinit var presenter: DetailPresenter
    lateinit var view: DetailView
    lateinit var weatherService: WeatherService
    lateinit var testScheduler: TestScheduler


    @Before
    fun setUp() {
        view = mock{}

        testScheduler = TestScheduler()
      // presenter = DetailPresenter(view, weatherService, testScheduler, testScheduler)
    }

    @Test
    fun shouldFetchWeather() {
        //when
        presenter.onCreate()

        //then
        verify(view).showLoader()


        reset(view)
        testScheduler.triggerActions()

        verify(view).hideLoader()
        verify(view, times(1)).updateWeather(weatherInfo)
        verify(view, never()).showLoader()

    }

    @Test
    fun shouldHandleNetworkError(){
     /*   val errorWeatherService: WeatherService = mock {
            on { getByCityName(eq("Bangalore"), any()) } doReturn Observable.error(Exception())}

        presenter = DetailPresenter(view, errorWeatherService, testScheduler, testScheduler)
        presenter.onCreate()

        verify(errorWeatherService).getByCityName(eq("Bangalore"), any())*/
        testScheduler.triggerActions()

        verify(view).hideLoader()
        verify(view).handleError()
        verify(view, never()).updateWeather(weatherInfo)

    }
}