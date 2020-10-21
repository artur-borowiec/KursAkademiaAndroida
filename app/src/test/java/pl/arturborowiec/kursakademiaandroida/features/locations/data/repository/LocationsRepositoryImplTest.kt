package pl.arturborowiec.kursakademiaandroida.features.locations.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.core.api.model.LocationsResponse
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapper
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.LocationDao
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.model.LocationCached
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.LocationsRepository
import pl.arturborowiec.kursakademiaandroida.mock.mock

internal class LocationsRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao> {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getLocations() }

        // then
        coVerify { locationDao.getLocations() }
    }
}
