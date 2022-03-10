package com.melihkarakilinc.memesapplication

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.melihkarakilinc.memesapplication.Util.Util
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
@BindingAdapter("setImage")
fun setImage(imageView: ImageView, path:String) {
    val util= Util()
    util.imageLoader(path,imageView)
}