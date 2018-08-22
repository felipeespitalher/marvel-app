package com.fpassos.marvelapp.model.network.response

import com.google.gson.annotations.SerializedName

data class ApiResponse<T> (
        @SerializedName("data")
        val data: T
)