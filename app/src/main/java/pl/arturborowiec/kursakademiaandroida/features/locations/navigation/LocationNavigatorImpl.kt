package pl.arturborowiec.kursakademiaandroida.features.locations.navigation

import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.navigation.FragmentNavigator
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import pl.arturborowiec.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : LocationNavigator {

    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
