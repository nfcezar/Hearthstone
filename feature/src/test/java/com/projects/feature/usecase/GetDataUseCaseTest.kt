package com.projects.feature.usecase

import com.projects.core.model.Card
import com.projects.core.repository.CardInfoRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetDataUseCaseTest {

    private lateinit var getCardDataUseCase: GetCardDataUseCase

    @MockK
    private lateinit var repository: CardInfoRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        getCardDataUseCase = GetCardDataUseCaseImpl(repository)
    }

    @Test
    fun `when call getCards should return a list with all cards`() = runBlocking {
        coEvery { repository.getData() } returns mockListCard

        val result = getCardDataUseCase.getCards()

        coVerify(exactly = 1) {
            getCardDataUseCase.getCards()
        }

        assertEquals(2, result.size)
    }

    companion object {
        private val mockListCard = listOf(
            Card(
                cardId = "AT_019",
                name = "Dreadsteed",
                type = "MINION",
                race = "DEMON",
                cardClass = "NEUTRAL",
            ),
            Card(
                cardId = "AT_029",
                name = "Buccaneer",
                type = "MINION",
                race = "PIRATE",
                cardClass = "NEUTRAL",
            )
        )
    }
}