package com.nasa.space.common.utils

import android.widget.ImageView
import com.nasa.space.R
import com.squareup.picasso.Picasso


class ImageLoader {

    companion object {

        private const val placeHolderId: Int = R.drawable.image_placeholder

        fun loadUrl(imageView: ImageView, url: String?) {
            val picasso = Picasso.get()

            if (!url.isNullOrEmpty()) {
                picasso.load(url)
                    .placeholder(placeHolderId)
                    .into(imageView)
            } else {
                picasso.load(placeHolderId)
                    .into(imageView)
            }
        }

    }
}