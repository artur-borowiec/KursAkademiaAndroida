package pl.arturborowiec.kursakademiaandroida.core.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.Origin

class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}
