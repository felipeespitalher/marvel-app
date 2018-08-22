package com.fpassos.marvelapp.model.network.authorization

interface TimestampGenerator {

    fun getTimestamp(): Long
}