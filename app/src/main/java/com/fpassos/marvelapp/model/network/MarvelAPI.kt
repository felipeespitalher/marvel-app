package com.fpassos.marvelapp.model.network

import com.fpassos.marvelapp.model.network.response.ApiResponse
import com.fpassos.marvelapp.model.network.response.CharacterResponseItem
import com.fpassos.marvelapp.model.network.response.ComicResponseItem
import com.fpassos.marvelapp.model.network.response.ItemListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelAPI {
    @GET("characters")
    fun getCharacters(
            @Query("apikey")
            apiKey: String,
            @Query("ts")
            timestamp: Long,
            @Query("hash")
            hash: String,
            @Query("limit")
            limit: Int = 30,
            @Query("offset")
            offset: Int = 0
    ): Call<ApiResponse<ItemListResponse<CharacterResponseItem>>>

    @GET("characters/{characterId}/comics")
    fun getCharacterComics(
            @Path("characterId")
            characterId: Int,
            @Query("apikey")
            apiKey: String,
            @Query("ts")
            timestamp: Long,
            @Query("hash")
            hash: String,
            @Query("limit")
            limit: Int = 30,
            @Query("offset")
            offset: Int = 0
    ): Call<ApiResponse<ItemListResponse<ComicResponseItem>>>
}