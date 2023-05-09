package com.projects.core.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("id")
    val cardId: String,
    val type: String,
    val name: String,
    val race: String,
    val cardClass: String,
    val image: String
)