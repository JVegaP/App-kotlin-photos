package com.alvic.app.ui.photos.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtils {
    fun loadImage(url: String, context: Context, imageView: ImageView) {
        Glide
            .with(context)
            .load(url)
            .into(imageView)
    }
}