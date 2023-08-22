package com.example.evaluacion_final.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.evaluacion_final.R
import com.example.evaluacion_final.data.db.PlayerDataBase
import com.example.evaluacion_final.data.repository.NbaPlayerRepository
import com.example.evaluacion_final.model.NbaPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerDetailViewModel(application: Application): AndroidViewModel(application){
    private val repository: NbaPlayerRepository
    init{
        val db = PlayerDataBase.getDatabase(application)
        repository = NbaPlayerRepository(db.nbaPlayerDao())
    }

    fun addFavorite(player: NbaPlayer){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFavorite(player)
        }
    }

    fun deleteFavorite(player: NbaPlayer){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteFavorite(player)
        }
    }
}