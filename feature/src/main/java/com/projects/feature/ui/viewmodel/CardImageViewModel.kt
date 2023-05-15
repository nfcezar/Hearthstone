package com.projects.feature.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.feature.usecase.GetCardDataUseCase
import kotlinx.coroutines.launch

class CardImageViewModel(
    private val getCardDataUseCase: GetCardDataUseCase
) : ViewModel() {

    private val _imageUrl = MutableLiveData<List<String>>()
    val imageUrl: LiveData<List<String>>
        get() = _imageUrl


    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            val ids = getCardDataUseCase.getCardId()
      //      _imageUrl.value = getCardDataUseCase.getImageUrl(ids)
        }
    }
}