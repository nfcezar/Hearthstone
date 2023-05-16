package com.projects.feature.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.projects.core.model.Card
import com.projects.feature.view.CustomCardInfoView

class HomeTypeViewHolder(
    private val customCardInfoView: CustomCardInfoView,
    private val action: () -> Unit
) : RecyclerView.ViewHolder(customCardInfoView) {
    fun onBindCard(card: Card) {
        with(customCardInfoView) {
            setCardSubtitle(card.type)
            onCardClick(action)
        }
    }
}