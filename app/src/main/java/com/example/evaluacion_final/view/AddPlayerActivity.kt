package com.example.evaluacion_final.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.evaluacion_final.R
import com.example.evaluacion_final.databinding.ActivityAddPlayerBinding
import com.example.evaluacion_final.model.PlayerFirebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddPlayerActivity : AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore
    private lateinit var binding: ActivityAddPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        binding = ActivityAddPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firestore = Firebase.firestore

        binding.btnRegisterPlayer.setOnClickListener {
            val name:String = binding.tilPlayerName.editText?.text.toString()
            val age: String = binding.tilPlayerAge.editText?.text.toString()
            val games: String = binding.tilPlayerGames.editText?.text.toString()
            val minutes_pg: String = binding.tilPlayerMinutes.editText?.text.toString()
            val PTS: String = binding.tilPlayerPts.editText?.text.toString()
            val team: String = binding.tilPlayerTeam.editText?.text.toString()
            val field_percent: String = binding.tilPlayerField.editText?.text.toString()
            if(name.isNotEmpty() && age.isNotEmpty() && games.isNotEmpty() && minutes_pg.isNotEmpty() && PTS.isNotEmpty() && team.isNotEmpty() && field_percent.isNotEmpty()){
                val player = hashMapOf(
                    "PTS" to PTS,
                    "age" to age.toInt(),
                    "field_percent" to field_percent,
                    "games" to games.toInt(),
                    "minutes_pg" to minutes_pg,
                    "name" to name,
                    "team" to team
                )
                firestore.collection("player")
                    .add(player)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Agregado Correctamente con id: ${it.id}", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "No se agregó el elemento", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

//    private fun getData(){
//        firestore.collection("player").get()
//            .addOnSuccessListener {
//                val players = mutableListOf<PlayerFirebase>()
//                for(document in it.documents){
//                    val player = PlayerFirebase(
//                        PTS = document.data?.get("PTS").toString(),
//                        age = document.data?.get("age").toString().toInt(),
//                        field_percent = document.data?.get("field_percent").toString(),
//                        games = document.data?.get("games").toString().toInt(),
//                        minutes_pg = document.data?.get("minutes_pg").toString(),
//                        name = document.data?.get("name").toString(),
//                        team = document.data?.get("team").toString(),
//                    )
//                    players.add(player)
//                }
//            }
//    }
}