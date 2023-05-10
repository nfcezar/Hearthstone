package com.projects.core.repository

import com.projects.core.model.Card
import com.projects.core.repository.CardInfoRepository
import com.projects.core.repository.CardInfoRepositoryImpl
import com.projects.core.service.HearthstoneApi
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CardInfoRepositoryTest {

    private lateinit var cardInfoRepository: CardInfoRepository

    @MockK
    private lateinit var api: HearthstoneApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        cardInfoRepository = CardInfoRepositoryImpl(
            api
        )
    }

    @Test
    fun `when call getData should get all cards`() = runBlocking {
        coEvery { api.getCards() } returns mockCardList

        val result = cardInfoRepository.getData()

        coVerify(exactly = 1) {
            cardInfoRepository.getData()
        }
        assertEquals(mockCardList, result)
    }

    companion object {
        private val mockCardList = listOf(
            Card(
                cardId = "ART_BOT_Bundle_001",
                name = "Golden Legendary",
                type = "MINION",
                race = null,
                cardClass = "NEUTRAL",
                imageUrl = null
            ),
            Card(
                cardId = "AT_001",
                name = "Flame Lance",
                type = "SPELL",
                race = null,
                cardClass = "MAGE",
                imageUrl = null
            )
        )
    }
}