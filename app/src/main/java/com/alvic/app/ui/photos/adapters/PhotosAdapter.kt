package com.alvic.app.ui.photos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.alvic.app.R
import com.alvic.app.databinding.ItemPhotoBinding
import com.alvic.app.ui.photos.utils.GlideUtils
import com.alvic.photos.data.models.PhotoModel

class PhotosAdapter(private var photos: MutableList<PhotoModel>, private val fragment: Fragment):
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: PhotoModel) = binding.apply {
            tvNamePhoto.text = photo.namePhoto
            tvIdPhoto.text = fragment.getString(R.string.name_photo,photo.id.toString())
            GlideUtils.loadImage(url = photo.urlPreviewPhoto, context = itemView.context, imageView = ivPhoto)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo = photo)
    }

    override fun getItemCount(): Int = photos.size
}