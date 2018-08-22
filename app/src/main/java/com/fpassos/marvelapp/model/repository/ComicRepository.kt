package com.fpassos.marvelapp.model.repository

import com.fpassos.marvelapp.model.Promise
import com.fpassos.marvelapp.model.data.Comic

interface ComicRepository {
    fun getComics(characterId: Int): Promise<List<Comic>>
}