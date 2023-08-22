package com.example.evaluacion_final.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.evaluacion_final.R
import com.example.evaluacion_final.databinding.FragmentPlayerDetailBinding
import com.example.evaluacion_final.databinding.FragmentPlayerFavoriteBinding
import com.example.evaluacion_final.model.NbaPlayer
import com.example.evaluacion_final.view.MainActivity

class PlayerDetailFragment : Fragment() {
    private lateinit var binding: FragmentPlayerDetailBinding
    val args: PlayerDetailFragmentArgs by navArgs()
    private lateinit var player: NbaPlayer
    private lateinit var viewModel: PlayerDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = args.player
        viewModel = ViewModelProvider(requireActivity()).get(PlayerDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtName.text = player.name
        binding.txtMinutes.text = player.minutes_pg
        binding.txtPuntosTotales.text = player.PTS
        binding.txtTirosCampo.text = "${(player.field_percent.toDouble() * 100).toString()}%"
        binding.btnAddFavorite.apply {
            visibility = if (player.isFavorite) View.GONE else View.VISIBLE
        }
        binding.btnEliminar.apply {
            visibility = if (player.isFavorite) View.VISIBLE else View.GONE
        }
        binding.btnEliminar.setOnClickListener {
            viewModel.deleteFavorite(player)
        }
        binding.btnAddFavorite.setOnClickListener{
            player.isFavorite = true
            viewModel.addFavorite(player)
        }
    }
}