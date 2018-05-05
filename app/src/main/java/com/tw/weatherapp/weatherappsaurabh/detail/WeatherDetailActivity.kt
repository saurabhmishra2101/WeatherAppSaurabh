package com.tw.weatherapp.weatherappsaurabh.detail

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tw.weatherapp.weatherappsaurabh.R
import com.tw.weatherapp.weatherappsaurabh.detail.network.NetworkUtility
import com.tw.weatherapp.weatherappsaurabh.detail.network.WeatherService
import com.tw.weatherapp.weatherappsaurabh.detail.util.APIName
import com.tw.weatherapp.weatherappsaurabh.detail.util.UtilsDialog
import org.json.JSONException
import org.json.JSONObject
import java.util.HashMap
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

private lateinit var presenter: DetailPresenter
private val weatherService: WeatherService?= null


class WeatherDetailActivity : AppCompatActivity(),DetailView {

    internal var util = UtilsDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (NetworkUtility.checkConnectivity(this@WeatherDetailActivity)) {
            val WeatherAPIURL = APIName.URL
            println("WEATHER URL IS---$WeatherAPIURL")
            WeatherDetailAPI(WeatherAPIURL)

        } else {
            util.dialog(this@WeatherDetailActivity, "Please check your internet connection.")
        }



    }



    private fun WeatherDetailAPI(url: String) {

        var pdia = ProgressDialog(this@WeatherDetailActivity)

        pdia.setMessage("Fetching Weather Information...")
        pdia.setCanceledOnTouchOutside(false)
        pdia.setCancelable(false)
        pdia.show()

        val stringRequest = object : StringRequest(Request.Method.GET, url,
                Response.Listener { response ->
                    pdia.dismiss()
                   


                    println("RESPONSE OF WEATHER DETAILS API IS---$response")
                    var WeatherJson: JSONObject? = null
                    try {
                        WeatherJson = JSONObject(response)

                        weatherdescrdesc.text = WeatherJson.getJSONArray("weather").getJSONObject(0).getString("description")

                        namedesc.text = WeatherJson.getString("name")








                    } catch (e: JSONException) {
                        e.printStackTrace()
                        pdia.dismiss()
                    }



                    humiditydesc




                },
                Response.ErrorListener { error ->

                     pdia.dismiss();

                    VolleyLog.d("TAG", "Error: " + error.message)
                    val networkResponse = error.networkResponse
                    println("network RESPONSE CODE--------" + networkResponse!!)

                    if (networkResponse != null) {
                        val respCode = networkResponse.statusCode


                        //  String respcodestr = Integer.toString(respCode);
                        if (respCode == 404) {
                            val respData = String(networkResponse.data)
                            println("RESPONSE DATA--------$respData")
                            

                        } else {
                            Toast.makeText(this@WeatherDetailActivity, error.message, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        util.dialog(this@WeatherDetailActivity, "Some Error Occured,Please try after some time")
                    }
                }) {
            override fun getParams(): Map<String, String> {


                return HashMap()
            }

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params = HashMap<String, String>()
                params["Content-Type"] = "application/x-www-form-urlencoded"
                return params
            }

        }

        stringRequest.retryPolicy = DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        val requestQueue = Volley.newRequestQueue(this@WeatherDetailActivity)
        requestQueue.add(stringRequest)
    }


}
