package com.fpassos.marvelapp

import android.app.Application
import com.fpassos.marvelapp.dependencyinjection.AppComponent
import com.fpassos.marvelapp.dependencyinjection.DaggerAppComponent

class MarvelApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .build()
    }

}