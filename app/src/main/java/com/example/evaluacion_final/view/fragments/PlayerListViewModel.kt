package com.example.evaluacion_final.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacion_final.data.repository.NbaPlayerRepository
import com.example.evaluacion_final.data.response.ApiResponse
import com.example.evaluacion_final.model.NbaPlayer
import com.example.evaluacion_final.model.getDataPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerListViewModel(): ViewModel() {
     val repository = NbaPlayerRepository()
    val playerList : MutableLiveData<List<NbaPlayer>> = MutableLiveData<List<NbaPlayer>>()

    fun getPlayerList(){
        val data = getDataPlayer()
        playerList.value = data
    }

    fun getPlayersFromService(){
        viewModelScope.launch(Dispatchers.IO){
            val response = repository.getPlayers()
            when(response){
                is ApiResponse.Error -> {

                }
                is ApiResponse.Success -> {
                    playerList.postValue(response.data.results)
                }
            }
        }
    }
}