package com.fpassos.marvelapp.model.network.authorization

import java.util.*

class DefaultTimestampGenerator : TimestampGenerator {
    override fun getTimestamp() = Date().time
}