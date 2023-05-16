package com.projects.feature.usecase

import com.projects.core.model.Card
import com.projects.core.repository.CardInfoRepository

class GetCardDataUseCaseImpl(
    private val repository: CardInfoRepository
) : GetCardDataUseCase {
    override suspend fun getCards(): List<Card> {
        return repository.getData()
    }
}