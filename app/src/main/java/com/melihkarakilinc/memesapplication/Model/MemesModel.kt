package com.melihkarakilinc.memesapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class MemesModel(
    val `data`: Data,
    val success: Boolean
)

data class Data(
    val memes: List<Meme>
)

@Parcelize
data class Meme(
    val box_count: Int,
    val height: Int,
    val id: String,
    val name: String,
    val url: String,
    val width: Int
): Parcelable {}