package com.projects.feature.usecase

import com.projects.core.repository.CardInfoRepository

class GetDataCategoryUseCaseImpl(
    private val repository: CardInfoRepository
) : GetDataCategoryUseCase {
    override suspend fun getClassName(): List<String> {
        return repository.getData().map {
            it.cardClass
        }
    }

    override suspend fun getTypeName(): List<String> {
        return repository.getData().map {
            it.type
        }
    }

    override suspend fun getRaceName(): List<String?> {
        return repository.getData().map {
            it.race
        }
    }
}