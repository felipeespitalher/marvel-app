package com.fpassos.marvelapp.ui

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

data class Listing<T>(
        val pagedList: LiveData<PagedList<T>>,
        val pageSize: Int,
        val status: LiveData<Status>,
        val refresh: () -> Unit
) {
    enum class Status {
        STATUS_LOADING, STATUS_ERROR, STATUS_INITIALIZED
    }
}