package com.projects.feature.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projects.feature.databinding.CustomImageviewBinding
import com.projects.feature.viewholder.CardImageViewHolder

class CardImageAdapter(
    private val context: Context,
    private val imagesUrl: List<String>
) : RecyclerView.Adapter<CardImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageViewHolder {
        val binding =
            CustomImageviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imagesUrl.size
    }

    override fun onBindViewHolder(holder: CardImageViewHolder, position: Int) {
        val image = imagesUrl[position]
        Glide.with(context)
            .load(image)
            .placeholder(com.bumptech.glide.R.drawable.abc_ab_share_pack_mtrl_alpha)
            .into(holder.imageview)
    }
}