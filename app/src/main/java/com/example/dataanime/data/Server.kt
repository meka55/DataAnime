package com.example.dataanime.data

import com.example.dataanime.models.AnimeModel

class Server {
    fun setAnime(): List<AnimeModel> {
        val animeList: MutableList<AnimeModel> = ArrayList()

        animeList.add(AnimeModel("Атака титанов"))
        animeList.add(AnimeModel("Тетрадь смерти"))
        animeList.add(AnimeModel("Твое имя"))
        animeList.add(AnimeModel("Город, в котором меня нет"))
        animeList.add(AnimeModel("Хантер х хантер"))
        animeList.add(AnimeModel("Банановая рыба"))
        animeList.add(AnimeModel("Клинок рассекающий демонов"))
        animeList.add(AnimeModel("Волейбол"))
        animeList.add(AnimeModel("Патриотизм Мориарти"))
        animeList.add(AnimeModel("Дитя погоды"))

        return animeList
    }
}