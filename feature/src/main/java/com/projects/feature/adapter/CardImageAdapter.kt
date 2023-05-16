package com.projects.feature.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.projects.core.model.Card
import com.projects.feature.R
import com.projects.feature.databinding.CustomImageviewBinding
import com.projects.feature.viewholder.CardImageViewHolder


private const val URL = "https://art.hearthstonejson.com/v1/render/latest/enUS/512x/"

class CardImageAdapter(
    private val context: Context,
    private val cardList: List<Card>
) : RecyclerView.Adapter<CardImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageViewHolder {
        val binding =
            CustomImageviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                .apply {
                    ViewGroup.LayoutParams.MATCH_PARENT
                    ViewGroup.LayoutParams.WRAP_CONTENT
                }
        return CardImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardImageViewHolder, position: Int) {
        val image = cardList[position]
        Glide.with(context)
            .load(URL + image.cardId + ".png")
            .placeholder(R.drawable.baseline_download_24)
            .into(holder.imageview)
    }
}