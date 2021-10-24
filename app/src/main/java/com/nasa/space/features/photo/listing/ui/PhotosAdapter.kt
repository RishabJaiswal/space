package com.nasa.space.features.photo.listing.ui


import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nasa.space.databinding.ListItemPhotoBinding
import com.nasa.space.features.photo.common.data.Photo

class PhotosAdapter(
    private val onPhotoClicked: (photo: Photo) -> Unit
) : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotoViewHolder(
        ListItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * view holder for photos & its details
     * */
    inner class PhotoViewHolder(
        private val photoItemViewBinding: ListItemPhotoBinding
    ) : RecyclerView.ViewHolder(photoItemViewBinding.root), OnClickListener {

        init {
            itemView.setOnClickListener(this)
            photoItemViewBinding.photo.clipToOutline = true
        }

        override fun onClick(v: View?) {
            if (adapterPosition == RecyclerView.NO_POSITION) return
            val selectedPhoto = getItem(adapterPosition)
            onPhotoClicked(selectedPhoto)
        }

        fun bind(photo: Photo) = with(photoItemViewBinding) {
            title.text = photo.title
            details.text = photo.details
        }
    }

    /**
     * This class propagates changes to the recycler view
     * for a given difference between old and new data
     * */
    private class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {

        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }
}