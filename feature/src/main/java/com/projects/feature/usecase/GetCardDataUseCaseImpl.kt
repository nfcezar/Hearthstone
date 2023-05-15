package com.projects.feature.usecase

import com.projects.core.model.Card
import com.projects.core.repository.CardInfoRepository

class GetCardDataUseCaseImpl(
    private val repository: CardInfoRepository
) : GetCardDataUseCase {
    override suspend fun getCardId(): List<String> {
        return repository.getData().map {
            it.cardId
        }
    }

    override suspend fun getCards(): List<Card> {
        return repository.getData()
    }

    override suspend fun getTypeName(): List<String?> {
        return repository.getData().map {
            it.type
        }
    }

    override suspend fun getRaceName(): List<String?> {
        return repository.getData().map {
            it.race
        }
    }

    override suspend fun getImageUrl(id: String): List<String> {
        return repository.getData().map {
            it.imageUrl + id + ".png"
        }
    }

    override suspend fun getCardById(id: String): List<Card> {
        return repository.getData().filter {
            it.cardId == id
        }
    }

    override suspend fun getCardByClass(className: String): List<Card> {
        return repository.getData().filter {
            it.cardClass == className
        }
    }
}