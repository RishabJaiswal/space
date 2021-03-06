package com.nasa.space.features.photo.listing.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nasa.space.databinding.ActivityPhotosBinding
import com.nasa.space.features.photo.common.viewmodel.PhotosViewModel
import com.nasa.space.features.photo.details.ui.PhotoDetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityPhotosBinding
    private val photosViewModel: PhotosViewModel by viewModels()
    private val photosAdapter by lazy {
        PhotosAdapter(
            onPhotoClicked = { _, position ->
                startActivity(PhotoDetailsActivity.getIntent(this, position))
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityPhotosBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setupPhotosRecyclerView()
        observePhotos()
        photosViewModel.getPhotos()
    }

    private fun setupPhotosRecyclerView() {
        viewBinding.content.listPhotos.adapter = photosAdapter
    }

    private fun observePhotos() {
        photosViewModel.photosLiveResult.observe(this) { photosResult ->
            if (photosResult.isSuccess()) {
                val photos = photosResult.data ?: emptyList()
                photosAdapter.submitList(photos)
            }
        }
    }
}