package com.projects.core.repository

import com.projects.core.model.Card

interface CardInfoRepository {
    suspend fun getData(): List<Card>
}