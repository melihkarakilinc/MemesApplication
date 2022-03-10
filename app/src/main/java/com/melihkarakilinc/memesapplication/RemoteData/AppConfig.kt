package com.melihkarakilinc.memesapplication.RemoteData

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConfig {
    fun ApiService(): DataApi =
        Retrofit.Builder().baseUrl("https://api.imgflip.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(DataApi::class.java)
}