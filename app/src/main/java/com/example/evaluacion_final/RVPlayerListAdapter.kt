package com.example.evaluacion_final

import android.icu.number.NumberFormatter.UnitWidth
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_final.databinding.ItemPlayerBinding
import com.example.evaluacion_final.model.NbaPlayer

class RVPlayerListAdapter(var results: List<NbaPlayer>, val onClick: (NbaPlayer) -> Unit): RecyclerView.Adapter<NbaPlayerVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaPlayerVH {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NbaPlayerVH(binding, onClick)
    }

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: NbaPlayerVH, position: Int) {
        holder.bind(results[position])
    }

}

class NbaPlayerVH(private val binding:ItemPlayerBinding, val onClick: (NbaPlayer) -> Unit): RecyclerView.ViewHolder(binding.root){
    fun bind(response: NbaPlayer) {
        binding.txtName.text = response.name
        binding.txtAge.text = response.age.toString()
        binding.txtGames.text = response.games.toString()
        binding.txtTeam.text = response.team
        binding.root.setOnClickListener {
            onClick(response)
        }
    }
}