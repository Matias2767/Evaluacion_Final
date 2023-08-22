package com.example.evaluacion_final.data.repository

import com.example.evaluacion_final.data.db.NbaPlayerDao
import com.example.evaluacion_final.data.response.ApiResponse
import com.example.evaluacion_final.data.response.PlayerListResponse
import com.example.evaluacion_final.data.retrofit.ServiceInstance
import com.example.evaluacion_final.model.NbaPlayer
import java.lang.Exception

class NbaPlayerRepository(val playerDao: NbaPlayerDao? = null){
     suspend fun getPlayers(): ApiResponse<PlayerListResponse>{
        return try{
            val response = ServiceInstance.getPlayerService().getPlayers()
            ApiResponse.Success(response)
        }catch (e:Exception){
            ApiResponse.Error(e)
        }

    }

    suspend fun addFavorite(player: NbaPlayer){
        playerDao?.let {
            it.addFavorite(player)
        }
    }

    fun getFavorites(): List<NbaPlayer>{
        playerDao?.let {
            return it.getFavorites()
        } ?: kotlin.run{
            return listOf()
        }
    }

    suspend fun deleteFavorite(player: NbaPlayer){
        playerDao?.let {
            it.deleteFavorite(player)
        }
    }

}