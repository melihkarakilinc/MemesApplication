package com.melihkarakilinc.memesapplication.RemoteData

import com.melihkarakilinc.memesapplication.MemesModel
import retrofit2.http.GET

interface DataApi {
    @GET("get_memes")
    suspend fun getMemes(): MemesModel
}