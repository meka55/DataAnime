package com.example.dataanime.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dataanime.viewModel.AnimeViewModel
import com.example.dataanime.ui.adapter.AnimeAdapter
import com.example.dataanime.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var adapter: AnimeAdapter = AnimeAdapter()
    private var animeViewModel: AnimeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
      binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        clickBtn()
        initialization()
        setUpObservers()
    }

    private fun setUpObservers() {
        animeViewModel?.dataAnime?.observe(viewLifecycleOwner) { books ->
            adapter.addText(books)
            binding.btn.visibility = View.GONE
        }
    }

    private fun initialization() {
        animeViewModel = ViewModelProvider(requireActivity())[AnimeViewModel::class.java]
    }

    private fun clickBtn() {
        binding.btn.setOnClickListener {
            binding.btn.visibility = View.GONE;
            animeViewModel?.setData()
        }
    }

    private fun setUpView() {
        binding.recycler.adapter = adapter
    }
}