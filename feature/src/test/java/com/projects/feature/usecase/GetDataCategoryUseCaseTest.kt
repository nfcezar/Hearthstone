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

class GetDataCategoryUseCaseTest {

    private lateinit var getDataCategoryUseCase: GetDataCategoryUseCase

    @MockK
    private lateinit var repository: CardInfoRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        getDataCategoryUseCase = GetDataCategoryUseCaseImpl(repository)
    }

    @Test
    fun `when call getClassName should return class name`() = runBlocking {
        coEvery { repository.getData() } returns mockListCard

        val result = getDataCategoryUseCase.getClassName()

        coVerify(exactly = 1) {
            getDataCategoryUseCase.getClassName()
        }

        assertEquals(listOf("NEUTRAL", "NEUTRAL"), result)
    }

    @Test
    fun `when call getRaceName should return race name`() = runBlocking {
        coEvery { repository.getData() } returns mockListCard

        val result = getDataCategoryUseCase.getRaceName()

        coVerify(exactly = 1) {
            getDataCategoryUseCase.getRaceName()
        }

        assertEquals(listOf("DEMON", "PIRATE"), result)
    }

    @Test
    fun `when call getTypeName should return type name`() = runBlocking {
        coEvery { repository.getData() } returns mockListCard

        val result = getDataCategoryUseCase.getTypeName()

        coVerify(exactly = 1) {
            getDataCategoryUseCase.getTypeName()
        }

        assertEquals(listOf("MINION", "MINION"), result)
    }

    companion object {
        private val mockListCard = listOf(
            Card(
                cardId = "AT_019",
                name = "Dreadsteed",
                type = "MINION",
                race = "DEMON",
                cardClass = "NEUTRAL",
                imageUrl = null
            ),
            Card(
                cardId = "AT_029",
                name = "Buccaneer",
                type = "MINION",
                race = "PIRATE",
                cardClass = "NEUTRAL",
                imageUrl = null
            )
        )
    }
}