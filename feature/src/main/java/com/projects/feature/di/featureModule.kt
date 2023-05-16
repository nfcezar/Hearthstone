package com.projects.feature.di

import com.projects.feature.ui.viewmodel.HomeViewModel
import com.projects.feature.usecase.GetCardDataUseCase
import com.projects.feature.usecase.GetCardDataUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    factory<GetCardDataUseCase> {
        GetCardDataUseCaseImpl(repository = get())
    }

    viewModel {
        HomeViewModel(getCardDataUseCase = get())
    }
}