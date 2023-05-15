package com.projects.core.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName(value = "id")
    val cardId: String,
    val name: String?,
    val type: String?,
    val race: String?,
    val cardClass: String,
    val imageUrl: String = "https://art.hearthstonejson.com/v1/render/latest/enUS/512x/"
)