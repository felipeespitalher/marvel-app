package com.fpassos.marvelapp.model.extensions

import com.fpassos.marvelapp.model.Promise
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.promisify() = Promise<T> { fulfill, reject ->
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            t?.let(reject)
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.body()?.let(fulfill)
        }

    })
}