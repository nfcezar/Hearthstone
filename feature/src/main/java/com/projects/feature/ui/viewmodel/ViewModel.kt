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

    private val _image = MutableLiveData<List<Card>>()
    val image: LiveData<List<Card>>
        get() = _image


    init {
        getInfoCard()
    }

    private fun getInfoCard() {
        viewModelScope.launch {
            val allCards = getCardDataUseCase.getCards()

            val distinctClassCard = allCards.distinctBy { it.cardClass }
            _classNameList.value = CardList(
                "Classes", distinctClassCard
            )

            val distinctRace = allCards.distinctBy { it.race }
            _raceListNames.value = CardList(
                "Races", distinctRace
            )

            val distinctType = allCards.distinctBy { it.type }
            _typeListNames.value = CardList(
                "Races", distinctType
            )
            _image.value = allCards
        }
    }
}

data class CardList(
    var title: String,
    var cards: List<Card>
)
