package com.projects.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projects.core.model.Card
import com.projects.feature.view.CustomCardInfoView
import com.projects.feature.viewholder.HomeRaceViewHolder

class HomeRaceAdapter(
    private val items: List<Card>
) : RecyclerView.Adapter<HomeRaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRaceViewHolder {
        val view = CustomCardInfoView(parent.context)
        return HomeRaceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HomeRaceViewHolder, position: Int) {
        val item = items[position]
        return holder.onBindCard(item)

    }
}