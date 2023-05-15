package com.projects.feature.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.core.model.Card
import com.projects.feature.usecase.GetCardDataUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCardDataUseCase: GetCardDataUseCase
) : ViewModel() {

    private val _classNameList = MutableLiveData<CardList>()
    val classNameList: LiveData<CardList>
        get() = _classNameList

    private val _raceListNames = MutableLiveData<CardList>()
    val raceListNames: LiveData<CardList>
        get() = _raceListNames

    private val _typeListNames = MutableLiveData<CardList>()
    val typeListNames: LiveData<CardList>
        get() = _typeListNames

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _classNameList.value = CardList(
                "Classes", getCardDataUseCase.getCards().distinctBy {
                    it.cardClass
                }
            )

            _raceListNames.value = CardList(
                "Types", getCardDataUseCase.getCards().distinctBy {
                    it.race
                }
            )

            _typeListNames.value = CardList(
                "Races", getCardDataUseCase.getCards().distinctBy {
                    it.type
                }
            )
        }
    }
}

data class CardList(
    var title: String,
    var cards: List<Card>
)
