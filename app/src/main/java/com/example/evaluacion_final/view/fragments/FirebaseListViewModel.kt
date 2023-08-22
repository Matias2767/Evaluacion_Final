package com.example.evaluacion_final.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.evaluacion_final.model.PlayerFirebase
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseListViewModel: ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()

    val playersFirebase: MutableLiveData<List<PlayerFirebase>> = MutableLiveData()
     fun loadFirebasePlayers(){
        firestore.collection("player").get()
            .addOnSuccessListener {
                val players = mutableListOf<PlayerFirebase>()
                for(document in it.documents){
                    val player = PlayerFirebase(
                        PTS = document.data?.get("PTS").toString(),
                        age = document.data?.get("age").toString().toInt(),
                        field_percent = document.data?.get("field_percent").toString(),
                        games = document.data?.get("games").toString().toInt(),
                        minutes_pg = document.data?.get("minutes_pg").toString(),
                        name = document.data?.get("name").toString(),
                        team = document.data?.get("team").toString(),
                    )
                    players.add(player)
                }
                playersFirebase.value = players
            }
    }
}