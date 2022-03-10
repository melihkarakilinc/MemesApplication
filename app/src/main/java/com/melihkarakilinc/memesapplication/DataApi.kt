package com.melihkarakilinc.memesapplication

import retrofit2.http.GET

interface DataApi {
    @GET("get_memes")
    suspend fun getMemes(): MemesModel
}