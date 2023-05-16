package com.projects.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projects.core.model.Card
import com.projects.feature.view.CustomCardInfoView
import com.projects.feature.viewholder.HomeTypeViewHolder

class HomeTypeAdapter(
    private val items: List<Card>,
    private val action: () -> Unit
) : RecyclerView.Adapter<HomeTypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTypeViewHolder {
        val view = CustomCardInfoView(parent.context)
        return HomeTypeViewHolder(view, action)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeTypeViewHolder, position: Int) {
        val item = items[position]
        return holder.onBindCard(item)
    }
}