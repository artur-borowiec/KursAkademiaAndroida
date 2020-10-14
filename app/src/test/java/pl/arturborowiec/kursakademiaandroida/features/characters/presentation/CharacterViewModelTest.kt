package pl.arturborowiec.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.core.base.UIState
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapper
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character
import pl.arturborowiec.kursakademiaandroida.mock.mock
import pl.arturborowiec.kursakademiaandroida.utils.ViewModelTest
import pl.arturborowiec.kursakademiaandroida.utils.getOrAwaitValue
import pl.arturborowiec.kursakademiaandroida.utils.observeForTesting

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        // given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        // given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.image shouldBe character.image
            characterDisplayable.species shouldBe character.species
            characterDisplayable.type shouldBe character.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = CharacterViewModel(useCase, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
