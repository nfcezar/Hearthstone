package com.projects.core.repository

import com.projects.core.model.Card
import com.projects.core.service.HearthstoneApi

class CardInfoRepositoryImpl(
    private val api: HearthstoneApi
) : CardInfoRepository {
    override suspend fun getData(): List<Card> {
        return api.getCards()
    }
}