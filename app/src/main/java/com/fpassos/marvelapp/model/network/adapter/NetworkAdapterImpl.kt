package com.fpassos.marvelapp.model.network.adapter

import com.fpassos.marvelapp.model.Promise
import com.fpassos.marvelapp.model.extensions.promisify
import com.fpassos.marvelapp.model.network.MarvelAPI
import com.fpassos.marvelapp.model.network.authorization.AuthorizationProvider
import com.fpassos.marvelapp.model.network.response.CharacterResponseItem
import com.fpassos.marvelapp.model.network.response.ComicResponseItem
import com.fpassos.marvelapp.model.network.response.ItemListResponse


class NetworkAdapterImpl(
        private val authorizationProvider: AuthorizationProvider,
        private val marvelAPI: MarvelAPI
) : NetworkAdapter {

    companion object {
        const val PUBLIC_KEY = "f2951b1fb8f1028ad4b1313dc85f4dfc"
        const val PRIVATE_KEY = "b32c1088318907f5fc47b71682d2f5f1db495616"
    }

    override fun getCharacters(limit: Int, offset: Int): Promise<ItemListResponse<CharacterResponseItem>> {
        val authData = authorizationProvider.getAuthorizationData()
        return marvelAPI.getCharacters(authData.apiKey, authData.timestamp, authData.hash, limit, offset)
                .promisify()
                .map { it.data }
    }

    override fun getComics(characterId: Int, limit: Int, offset: Int): Promise<ItemListResponse<ComicResponseItem>> {
        val authData = authorizationProvider.getAuthorizationData()
        return marvelAPI.getCharacterComics(characterId, authData.apiKey, authData.timestamp, authData.hash, limit, offset)
                .promisify()
                .map { it.data }
    }
}