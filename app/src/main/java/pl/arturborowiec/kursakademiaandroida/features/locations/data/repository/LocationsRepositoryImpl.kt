package pl.arturborowiec.kursakademiaandroida.features.locations.data.repository

import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapper
import pl.arturborowiec.kursakademiaandroida.core.exception.callOrThrow
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.LocationDao
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.model.LocationCached
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.LocationsRepository
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

class LocationsRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : LocationsRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getLocationsFromRemote() }
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }
}
