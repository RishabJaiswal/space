package com.nasa.space.features.photo.details.ui

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nasa.space.features.photo.common.data.Photos

class PhotosPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val photos: Photos
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = photos.count()

    override fun createFragment(position: Int) = PhotoDetailsFragment(photos[position])
}