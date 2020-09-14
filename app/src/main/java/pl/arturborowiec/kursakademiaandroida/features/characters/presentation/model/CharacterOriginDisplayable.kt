package pl.arturborowiec.kursakademiaandroida.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}
