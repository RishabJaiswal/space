package com.nasa.space.features.photo.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nasa.space.databinding.FragmentPhotoDetailsBinding
import com.nasa.space.features.photo.common.data.Photo

class PhotoDetailsFragment(val photo: Photo) : Fragment() {

    private lateinit var viewBinding: FragmentPhotoDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentPhotoDetailsBinding.inflate(inflater, container, false)
        return viewBinding.let {
            it.title.text = photo.title
            it.copyrightOwner.text = photo.copyrightOwner
            it.explanation.text = photo.explanation
            it.root
        }
    }

}