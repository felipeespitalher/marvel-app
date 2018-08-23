package com.fpassos.marvelapp.ui.characterslist

import android.arch.lifecycle.ViewModel
import android.support.v7.util.DiffUtil
import com.fpassos.marvelapp.model.data.MarvelCharacter
import com.fpassos.marvelapp.model.extensions.map
import com.fpassos.marvelapp.model.repository.CharactersRepository
import com.fpassos.marvelapp.ui.Listing
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(repository: CharactersRepository) : ViewModel() {

    val characters = repository.characters

    val error = repository.characters?.let { character -> character.status.map { it == Listing.Status.STATUS_ERROR } }

    fun retry() {
        characters.refresh()
    }

    val itemCallback = object : DiffUtil.ItemCallback<MarvelCharacter>() {
        override fun areItemsTheSame(oldItem: MarvelCharacter?, newItem: MarvelCharacter?) = oldItem?.id == newItem?.id

        override fun areContentsTheSame(oldItem: MarvelCharacter?, newItem: MarvelCharacter?) = oldItem == newItem

    }

}