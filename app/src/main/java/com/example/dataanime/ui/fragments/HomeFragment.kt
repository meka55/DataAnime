package com.example.dataanime.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dataanime.R
import com.example.dataanime.ui.adapter.AnimeAdapter
import com.example.dataanime.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var adapter: AnimeAdapter = AnimeAdapter()
    private var homeViewModel: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpListeners()
        initialization()
        setUpObservers()
    }

    private fun setUpView() {
        binding.recycler.adapter = adapter
    }

    private fun setUpListeners() {
        binding.btn.setOnClickListener {
            binding.btn.visibility = View.GONE;
            homeViewModel?.setData()
        }
    }

    private fun initialization() {
        homeViewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    private fun setUpObservers() {
        homeViewModel?.dataAnime?.observe(viewLifecycleOwner) { books ->
            adapter.addText(books)
            binding.btn.visibility = View.GONE
        }
    }
}