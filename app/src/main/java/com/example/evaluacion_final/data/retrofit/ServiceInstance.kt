package com.example.evaluacion_final.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://nba-stats-db.herokuapp.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getPlayerService():PlayerService = retrofit.create(PlayerService::class.java)


}