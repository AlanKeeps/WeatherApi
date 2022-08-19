package com.example.weatherapi

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weatherapi.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "f7140aa9afaa4498a42140255221908"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bGet.setOnClickListener {
            getResult("London")
        }
    }

    private fun getResult(name: String){
        val url = "http://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
        url,
            {
                    responce->
                val obj = JSONObject(responce)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Volley Responce: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog", "Volley Error: ${it.toString()}")
            })
        queue.add(stringRequest)
    }

}