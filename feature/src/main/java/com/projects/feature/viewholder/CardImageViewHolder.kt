package com.projects.feature.viewholder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.projects.feature.databinding.CustomImageviewBinding

class CardImageViewHolder(
    binding: CustomImageviewBinding,
) : RecyclerView.ViewHolder(binding.root) {
    var imageview: ImageView = binding.cardImage
}