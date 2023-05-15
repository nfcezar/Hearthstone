package com.projects.feature.usecase

import com.projects.core.model.Card

interface GetCardDataUseCase {
    suspend fun getCardId(): List<String>
    suspend fun getCards(): List<Card>
    suspend fun getTypeName(): List<String?>
    suspend fun getRaceName(): List<String?>
    suspend fun getImageUrl(id: String): List<String>
    suspend fun getCardById(id: String): List<Card>
    suspend fun getCardByClass(className: String): List<Card>
}