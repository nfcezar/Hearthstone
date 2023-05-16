package com.projects.feature.usecase

import com.projects.core.model.Card

interface GetCardDataUseCase {
    suspend fun getCards(): List<Card>
}