package com.example.evaluacion_final.view.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacion_final.data.db.PlayerDataBase
import com.example.evaluacion_final.data.repository.NbaPlayerRepository
import com.example.evaluacion_final.model.NbaPlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayerFavoriteViewModel(application: Application): AndroidViewModel(application) {
    private val repository: NbaPlayerRepository
    private val _favorites: MutableLiveData<List<NbaPlayer>> = MutableLiveData()
    val favorites: LiveData<List<NbaPlayer>> = _favorites
    init{
        val db = PlayerDataBase.getDatabase(application)
        repository = NbaPlayerRepository(db.nbaPlayerDao())
        loadFavorites()
    }

//    fun getFavorites(){
//        val data = repository.getFavorites()
//        _favorites.value = data
//    }

    fun loadFavorites(){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getFavorites()
            withContext(Dispatchers.Main){
                _favorites.value = data
            }
        }
    }
}