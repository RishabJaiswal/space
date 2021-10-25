package com.nasa.space.features.photo.details.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nasa.space.databinding.ActivityPhotoDetailsBinding
import com.nasa.space.features.photo.common.data.Photos
import com.nasa.space.features.photo.common.viewmodel.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailsActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityPhotoDetailsBinding
    private val photosViewModel: PhotosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPhotoDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        observePhotos()
        photosViewModel.getPhotos()
    }


    private fun setupPhotosPager(photos: Photos) {
        viewBinding.photosPager.adapter = PhotosPagerAdapter(this, photos)
    }

    private fun showSelectedPhoto() {
        viewBinding.photosPager.apply {
            if (this.adapter != null) {
                currentItem = intent.extras?.getInt(PHOTO_POSITION) ?: 0
            }
        }
    }

    private fun observePhotos() {
        photosViewModel.photosLiveResult.observe(this) { photosResult ->
            if (photosResult.isSuccess()) {
                val photos = photosResult.data ?: emptyList()
                setupPhotosPager(photos)
                showSelectedPhoto()
            }
        }
    }

    companion object {
        const val PHOTO_POSITION = "position"

        fun getIntent(context: Context, photoIndex: Int): Intent {
            return Intent(context, PhotoDetailsActivity::class.java).apply {
                putExtra(PHOTO_POSITION, photoIndex)
            }
        }
    }
}