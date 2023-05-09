package com.projects.core.service

import com.projects.core.model.Card
import retrofit2.http.GET

interface HearthstoneApi {
    @GET
    suspend fun getCards(): List<Card>
}