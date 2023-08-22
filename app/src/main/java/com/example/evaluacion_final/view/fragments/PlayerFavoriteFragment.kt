package com.example.evaluacion_final.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_final.R
import com.example.evaluacion_final.RVPlayerListAdapter
import com.example.evaluacion_final.databinding.FragmentPlayerFavoriteBinding
import com.example.evaluacion_final.databinding.FragmentPlayerListBinding
import kotlinx.coroutines.launch

class PlayerFavoriteFragment : Fragment() {
    private lateinit var binding: FragmentPlayerFavoriteBinding
    private lateinit var viewModel: PlayerFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PlayerFavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVPlayerListAdapter(listOf()){nbaPlayer ->
            val playerDetailDirection = PlayerFavoriteFragmentDirections.actionPlayerFavoriteFragmentToPlayerDetailFragment(nbaPlayer)
            findNavController().navigate(playerDetailDirection)
        }
        binding.rvPlayerFavoriteList.adapter = adapter
        binding.rvPlayerFavoriteList.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)

        viewLifecycleOwner.lifecycleScope.launch{
            viewModel.favorites.observe(viewLifecycleOwner){
                adapter.results = it
                adapter.notifyDataSetChanged()
            }
        }

        viewModel.loadFavorites()
    }
}