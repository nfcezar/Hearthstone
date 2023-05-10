package com.projects.feature.usecase

interface GetDataCategoryUseCase {

    suspend fun getClassName(): List<String>
    suspend fun getTypeName(): List<String>
    suspend fun getRaceName(): List<String?>
}