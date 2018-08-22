package com.fpassos.marvelapp.model.repository

import com.fpassos.marvelapp.model.Promise
import com.fpassos.marvelapp.model.data.Comic
import com.fpassos.marvelapp.model.network.adapter.NetworkAdapter

class MarvelComicRepository(private val networkAdapter: NetworkAdapter) : ComicRepository {

    override fun getComics(characterId: Int): Promise<List<Comic>> {
        return networkAdapter.getComics(characterId)
                .map { item -> item.results.map { it.toComic() } }
    }

}