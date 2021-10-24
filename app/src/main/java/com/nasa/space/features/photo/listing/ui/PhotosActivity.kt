package com.nasa.space.features.photo.listing.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nasa.space.databinding.ActivityMainBinding
import com.nasa.space.features.photo.listing.PhotosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private val photosViewModel: PhotosViewModel by viewModels()
    private val photosAdapter by lazy {
        PhotosAdapter(onPhotoClicked = {})
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
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