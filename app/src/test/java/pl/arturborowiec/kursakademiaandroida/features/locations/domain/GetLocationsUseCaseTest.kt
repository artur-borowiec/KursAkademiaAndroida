package pl.arturborowiec.kursakademiaandroida.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.features.locations.LocationsRepository

internal class GetLocationsUseCaseTest {

    @Test
    fun `when use case is invoked then getLocations method from repository is executed`() {
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
