package pl.arturborowiec.kursakademiaandroida.core.features.location.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.location.domain.model.Location

data class LocationDisplayable(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        dimension = location.dimension,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
}
