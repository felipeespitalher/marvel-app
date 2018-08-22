package com.fpassos.marvelapp.ui.characterdetails

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.fpassos.marvelapp.model.data.Comic
import com.fpassos.marvelapp.model.data.MarvelCharacter
import com.fpassos.marvelapp.model.extensions.MutableLiveData
import com.fpassos.marvelapp.model.extensions.dateString
import com.fpassos.marvelapp.model.extensions.map
import com.fpassos.marvelapp.model.repository.ComicRepository
import java.text.DateFormat
import javax.inject.Inject

class CharacterDetailsViewModel(private val character: MarvelCharacter, private val comicRepository: ComicRepository) : ViewModel() {

    val id = character.id
    val name = character.name
    val imageUrl = character.imageUrl
    val dateCreated = character.dateCreated?.dateString(style = DateFormat.MEDIUM)
    val description = character.description

    init {
        loadComics()
    }

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>>
        get() = _comics

    fun retry() {
        _loading.postValue(true)
        loadComics()
    }

    private fun loadComics() {
        comicRepository.getComics(character.id)
                .onError {
                    _loading.postValue(false)
                    _error.postValue(true)
                }
                .onSuccess {
                    _loading.postValue(false)
                    _comics.postValue(it)
                }
    }

    val showComics = comics.map { it.isNotEmpty() }

    class Factory @Inject constructor(private val comicRepository: ComicRepository) : ViewModelProvider.Factory {

        lateinit var character: MarvelCharacter

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>) = CharacterDetailsViewModel(character, comicRepository) as T
    }
}