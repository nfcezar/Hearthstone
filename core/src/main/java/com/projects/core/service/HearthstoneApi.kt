package com.projects.core.service

import com.projects.core.model.Card
import retrofit2.http.GET

interface HearthstoneApi {
    @GET("enUS/cards.json")
    suspend fun getCards(): List<Card>
}