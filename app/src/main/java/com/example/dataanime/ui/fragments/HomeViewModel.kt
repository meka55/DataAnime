package com.example.dataanime.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dataanime.data.Server
import com.example.dataanime.models.AnimeModel

class HomeViewModel : ViewModel()  {

    private val server: Server = Server()
    private val _dataAnime: MutableLiveData<List<AnimeModel>> = MutableLiveData<List<AnimeModel>>()
    var dataAnime: LiveData<List<AnimeModel>> = _dataAnime

    fun setData() {
        _dataAnime.value = server.setAnime()
    }
}