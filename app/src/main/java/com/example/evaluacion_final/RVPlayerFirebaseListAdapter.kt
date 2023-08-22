package com.example.evaluacion_final

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_final.databinding.ItemPlayerBinding
import com.example.evaluacion_final.model.NbaPlayer
import com.example.evaluacion_final.model.PlayerFirebase

class RVPlayerFirebaseListAdapter(var results: List<PlayerFirebase>, val onClick: (PlayerFirebase) -> Unit): RecyclerView.Adapter<PlayerFirebaseVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerFirebaseVH {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerFirebaseVH(binding, onClick)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: PlayerFirebaseVH, position: Int) {
        holder.bind(results[position])
    }
}

class PlayerFirebaseVH(private val binding:ItemPlayerBinding, val onClick: (PlayerFirebase) -> Unit): RecyclerView.ViewHolder(binding.root){
    fun bind(response: PlayerFirebase) {
        binding.txtName.text = response.name
        binding.txtAge.text = response.age.toString()
        binding.txtGames.text = response.games.toString()
        binding.txtTeam.text = response.team
        binding.root.setOnClickListener {
            onClick(response)
        }
    }
}