package com.example.bishkekrielt.data.remote

import com.example.bishkekrielt.data.model.Db
import com.example.bishkekrielt.data.model.WeatherData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SharesService {

    @GET("db")
    fun getShares(
            @Query("appid") appId: String
    ): Response<Db>

    @GET("data/2.5/weather")
    fun getWeather(
            @Query("q") city: String,
            @Query("appid") appId: String,
            @Query("units") units: String
    ): Response<WeatherData>
}