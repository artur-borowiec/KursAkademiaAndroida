package pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.core.base.UIState
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapper
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location
import pl.arturborowiec.kursakademiaandroida.features.locations.navigation.LocationNavigator
import pl.arturborowiec.kursakademiaandroida.mock.mock
import pl.arturborowiec.kursakademiaandroida.utils.ViewModelTest
import pl.arturborowiec.kursakademiaandroida.utils.getOrAwaitValue
import pl.arturborowiec.kursakademiaandroida.utils.observeForTesting

internal class LocationViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location is clicked THEN open location details screen`() {
        // given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)
        val location = LocationDisplayable.mock()

        // when
        viewModel.onLocationClick(location)

        // then
        verify { locationNavigator.openLocationDetailsScreen(location) }
    }

    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        // given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        // when
        viewModel.locations.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        // given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        // when
        viewModel.locations.observeForTesting()

        // then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        // given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        // when
        viewModel.locations.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.type shouldBe location.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = LocationViewModel(useCase, locationNavigator, errorMapper)

        // when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
