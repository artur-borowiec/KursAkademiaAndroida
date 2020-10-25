package pl.arturborowiec.kursakademiaandroida.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetCharactersUseCaseTest {

    @Test
    fun `WHEN use case is invoked THEN getCharacters method from repository is executed`() {
        // given
        val repository = mockk<CharactersRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getCharacters() }
    }
}
