package com.fpassos.marvelapp.model.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations

fun <T, R> LiveData<T>.map(transform: (T) -> R): LiveData<R> = Transformations.map(this, transform)

fun <T, R> LiveData<T>.switchMap(transform: (T) -> LiveData<R>): LiveData<R> = Transformations.switchMap(this, transform)

fun <T> MutableLiveData(initialValue: T) = android.arch.lifecycle.MutableLiveData<T>().apply {
    postValue(initialValue)
}