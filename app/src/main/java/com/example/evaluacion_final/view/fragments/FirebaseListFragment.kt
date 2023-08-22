package com.example.evaluacion_final.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacion_final.R
import com.example.evaluacion_final.RVPlayerFirebaseListAdapter
import com.example.evaluacion_final.databinding.FragmentFirebaseListBinding
import com.example.evaluacion_final.model.PlayerFirebase
import com.example.evaluacion_final.view.AddPlayerActivity


class FirebaseListFragment : Fragment() {
    private lateinit var binding: FragmentFirebaseListBinding
    private lateinit var adapter: RVPlayerFirebaseListAdapter
    //private val playersFirebase = mutableListOf<PlayerFirebase>()
    private lateinit var viewModel: FirebaseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirebaseListBinding.inflate(inflater, container, false)
        binding.fabAddPlayer.setOnClickListener {
            val intent = Intent(requireContext(), AddPlayerActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FirebaseListViewModel::class.java)
        adapter = RVPlayerFirebaseListAdapter(emptyList()) { playerFirebase ->
            
        }
        binding.rvFirebaseList.adapter = adapter
        binding.rvFirebaseList.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        viewModel.playersFirebase.observe(viewLifecycleOwner){
            adapter.results = it
            adapter.notifyDataSetChanged()
        }
        viewModel.loadFirebasePlayers()
    }

}