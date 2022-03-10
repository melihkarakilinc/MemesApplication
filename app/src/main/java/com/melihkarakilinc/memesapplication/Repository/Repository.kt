package com.melihkarakilinc.memesapplication.Repository

import com.melihkarakilinc.memesapplication.RemoteData.DataApi

class Repository(private val dataApi: DataApi) {
    suspend fun getMemes() = dataApi.getMemes()
}