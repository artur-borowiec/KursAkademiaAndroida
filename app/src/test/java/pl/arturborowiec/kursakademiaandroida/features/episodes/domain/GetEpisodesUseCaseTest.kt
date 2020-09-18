package pl.arturborowiec.kursakademiaandroida.features.episodes.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetEpisodesUseCaseTest {

    @Test
    fun `when use case is invoked then getEpisodes method from repository is executed`() {
        // given
        val repository = mockk<EpisodesRepository>(relaxed = true)
        val useCase = GetEpisodesUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getEpisodes() }
    }
}
