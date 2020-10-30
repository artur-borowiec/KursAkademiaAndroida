package pl.arturborowiec.kursakademiaandroida.features.locations.navigation

import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}
