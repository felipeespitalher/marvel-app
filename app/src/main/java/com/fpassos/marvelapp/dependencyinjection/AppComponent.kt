package com.fpassos.marvelapp.dependencyinjection

import dagger.Component
import com.fpassos.marvelapp.ui.characterdetails.CharacterDetailsFragment
import com.fpassos.marvelapp.ui.characterslist.CharacterListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    fun inject(characterListFragment: CharacterListFragment)
    fun inject(characterDetailsFragment: CharacterDetailsFragment)

}