package com.nasa.space.common.utils

import android.widget.ImageView
import com.nasa.space.R
import com.squareup.picasso.Picasso


class ImageLoader {

    companion object {

        const val placeHolderId: Int = R.drawable.image_placeholder

        fun loadUrl(imageView: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                Picasso.get()
                    .load(url)
                    .placeholder(placeHolderId)
                    .into(imageView)
            } else {
                Picasso.get()
                    .load(placeHolderId)
                    .into(imageView)
            }
        }

    }
}