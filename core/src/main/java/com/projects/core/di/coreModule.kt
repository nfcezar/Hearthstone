package com.projects.core.di

import com.projects.core.api.HearthstoneInfoApiService
import com.projects.core.repository.CardInfoRepository
import com.projects.core.repository.CardInfoRepositoryImpl
import org.koin.dsl.module

val coreModule = module {
    single<CardInfoRepository> {
        CardInfoRepositoryImpl(
            HearthstoneInfoApiService.createInstance()
        )
    }
}