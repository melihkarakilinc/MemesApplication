package com.melihkarakilinc.memesapplication.Util

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.melihkarakilinc.memesapplication.R

class Util {
    fun imageLoader(path: String, imageView: ImageView) {
        imageView.load(path) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            transformations(RoundedCornersTransformation())
        }
    }
}