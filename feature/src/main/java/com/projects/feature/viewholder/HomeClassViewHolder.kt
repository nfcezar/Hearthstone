package com.projects.feature.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.projects.core.model.Card
import com.projects.feature.view.CustomCardInfoView

class HomeClassViewHolder(
    private val customCardInfoView: CustomCardInfoView,
    private val action: () -> Unit
) : RecyclerView.ViewHolder(customCardInfoView) {
    fun onBindCard(className: Card) {
        with(customCardInfoView) {
            setCardSubtitle(className.cardClass)
            onCardClick(action)
        }
    }
}