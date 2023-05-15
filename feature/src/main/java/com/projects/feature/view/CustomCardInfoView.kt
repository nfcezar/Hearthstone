package com.projects.feature.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.projects.feature.R
import com.projects.feature.databinding.CustomCardInfoBinding
import kotlin.random.Random

class CustomCardInfoView(
    context: Context,
    attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {

    private val binding =
        CustomCardInfoBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setCardColor()
    }

    fun setCardSubtitle(text: String?) {
        binding.homeInfoTextView.text = text
    }

    private fun setCardColor() {
        val color = when (Random.nextInt(0, 9)) {
            1 -> R.color.green
            2 -> R.color.pink
            3 -> R.color.purple
            4 -> R.color.burlywood
            5 -> R.color.yellow
            6 -> R.color.light_blue
            7 -> R.color.light_gray
            8 -> R.color.orange
            else -> {
                R.color.coral_red
            }
        }
        binding.homeInfoCardView.setCardBackgroundColor(context.getColor(color))
    }

    fun onCardClick(action: () -> Unit) {
        binding.homeInfoCardView.setOnClickListener {
            action.invoke()
        }
    }
}