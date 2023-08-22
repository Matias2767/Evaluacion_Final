package com.example.evaluacion_final.data.retrofit

import com.example.evaluacion_final.data.response.PlayerListResponse
import retrofit2.http.GET

interface PlayerService {
    @GET("api/playerdata/?format=json")
    suspend fun getPlayers() : PlayerListResponse
}