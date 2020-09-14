package pl.arturborowiec.kursakademiaandroida.features.locations.domain

import pl.arturborowiec.kursakademiaandroida.base.UseCase
import pl.arturborowiec.kursakademiaandroida.features.locations.LocationsRepository
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationsRepository: LocationsRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit): List<Location> = locationsRepository.getLocations()
}
