package com.example.evaluacion_final.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_final.R
import com.example.evaluacion_final.databinding.FragmentPlayerListBinding
import com.example.evaluacion_final.model.getDataPlayer
import com.example.evaluacion_final.RVPlayerListAdapter
import com.example.evaluacion_final.model.NbaPlayer

class PlayerListFragment : Fragment() {
    private lateinit var binding: FragmentPlayerListBinding
    private lateinit var viewModel: PlayerListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(PlayerListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVPlayerListAdapter(listOf()){nbaPlayer ->
            val playerDetailDirection = PlayerListFragmentDirections.actionPlayerListFragmentToPlayerDetailFragment(nbaPlayer)
            findNavController().navigate(playerDetailDirection)
        }
        binding.rvPlayerList.adapter = adapter
        binding.rvPlayerList.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        viewModel.playerList.observe(viewLifecycleOwner){
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getPlayersFromService()
        //viewModel.getPlayerList()
    }


}