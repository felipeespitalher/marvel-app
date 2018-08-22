package com.fpassos.marvelapp.model.network.authorization

interface HashGenerator {
    fun generateHash(input: String): String
}