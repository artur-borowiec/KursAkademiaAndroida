package pl.arturborowiec.kursakademiaandroida.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {

    @Test
    fun `WHEN use case is invoked THEN getLocations method from repository is executed`() {
        //given
        val repository = mockk<LocationsRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        // when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        // then
        coVerify { repository.getLocations() }
    }
}
