package com.example.bishkekrielt.data.interactors

import com.example.bishkekrielt.data.model.Db
import com.example.bishkekrielt.data.model.WeatherData
import com.example.bishkekrielt.data.remote.SharesService
import retrofit2.Response

interface RieltInteractor {
    suspend fun loadDescription(): Response <WeatherData>

}

class RieltInteractorImp(private val service: SharesService) : RieltInteractor {
    override suspend fun loadDescription(): Response<WeatherData> {
        return service.getWeather("Bishkek","EnKUTj7VDqVE0Cnu63SCYny69JzzTllJdhzVCmZb?id_parameter=17792", "metric")
    }

}