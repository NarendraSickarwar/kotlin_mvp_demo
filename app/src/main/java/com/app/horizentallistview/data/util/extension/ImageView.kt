package com.app.horizentallistview.data.util.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Narendra Singh on 12/6/2019.
 */

internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
            .load(url)
            .asBitmap()
            .centerCrop()
            .into(this)
}