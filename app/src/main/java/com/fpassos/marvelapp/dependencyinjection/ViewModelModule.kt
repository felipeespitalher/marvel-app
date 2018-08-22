package com.fpassos.marvelapp.dependencyinjection

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.fpassos.marvelapp.ui.ViewModelFactory
import com.fpassos.marvelapp.ui.characterslist.CharactersListViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharactersListViewModel::class)
    abstract fun bindCharacterListViewModel(charactersListViewModel: CharactersListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}