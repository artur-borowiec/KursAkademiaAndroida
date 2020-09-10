package pl.arturborowiec.kursakademiaandroida.core.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.CharacterLocation

data class CharacterLocationDisplayable (
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}
