package pl.arturborowiec.kursakademiaandroida.core.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.CharacterOrigin

class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}
