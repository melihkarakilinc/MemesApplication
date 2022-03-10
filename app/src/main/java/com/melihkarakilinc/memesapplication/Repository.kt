package com.melihkarakilinc.memesapplication

class Repository(private val dataApi: DataApi) {
    suspend fun getMemes() = dataApi.getMemes()
}