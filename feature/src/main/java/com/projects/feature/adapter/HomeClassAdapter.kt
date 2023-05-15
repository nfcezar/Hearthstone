package com.projects.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projects.core.model.Card
import com.projects.feature.view.CustomCardInfoView
import com.projects.feature.viewholder.HomeClassViewHolder

class HomeClassAdapter(
    private val items: List<Card>,
    private val action: () -> Unit
) : RecyclerView.Adapter<HomeClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeClassViewHolder {
        val view = CustomCardInfoView(parent.context)
        return HomeClassViewHolder(view, action)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeClassViewHolder, position: Int) {
        val item = items[position]
        return holder.onBindCard(item)

    }
}