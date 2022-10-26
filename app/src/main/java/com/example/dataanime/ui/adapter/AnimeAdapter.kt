package com.example.dataanime.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dataanime.databinding.AnimeItemBinding
import com.example.dataanime.models.AnimeModel

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeHolder>() {
    private var animeList: List<AnimeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addText(moviesList: List<AnimeModel>) {
        this.animeList = moviesList
        notifyDataSetChanged()
    }

    class AnimeHolder(private val item: AnimeItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(animeModel: AnimeModel) {
            item.animeNameTv.text = animeModel.nameAnime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        return AnimeHolder(
            AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }
}