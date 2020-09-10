package pl.arturborowiec.kursakademiaandroida.core.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.Location

data class LocationDisplayable (
    val name: String,
    val url: String
) {
    constructor(location: Location) : this(
        name = location.name,
        url = location.url
    )
}
