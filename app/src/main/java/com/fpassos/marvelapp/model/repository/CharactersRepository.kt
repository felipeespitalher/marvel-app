package com.fpassos.marvelapp.model.repository

import com.fpassos.marvelapp.model.data.MarvelCharacter
import com.fpassos.marvelapp.ui.Listing

interface CharactersRepository {
    val characters: Listing<MarvelCharacter>
}