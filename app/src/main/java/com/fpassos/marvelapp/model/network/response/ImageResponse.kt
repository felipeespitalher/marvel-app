package com.fpassos.marvelapp.model.network.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
        @SerializedName("path")
        val path: String = "",
        @SerializedName("extension")
        val extension: String = ""
) {
    override fun toString() = "$path.$extension"
}