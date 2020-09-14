package pl.arturborowiec.kursakademiaandroida.features.locations

import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

interface LocationsRepository {
    suspend fun getLocations(): List<Location>
}
