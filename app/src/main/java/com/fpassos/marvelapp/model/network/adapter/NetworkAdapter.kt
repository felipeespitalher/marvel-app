package com.fpassos.marvelapp.model.network.adapter

import com.fpassos.marvelapp.model.Promise
import com.fpassos.marvelapp.model.network.response.CharacterResponseItem
import com.fpassos.marvelapp.model.network.response.ComicResponseItem
import com.fpassos.marvelapp.model.network.response.ItemListResponse

interface NetworkAdapter {
    fun getCharacters(limit: Int = 30, offset: Int = 0): Promise<ItemListResponse<CharacterResponseItem>>
    fun getComics(characterId: Int, limit: Int = 30, offset: Int = 0): Promise<ItemListResponse<ComicResponseItem>>
}