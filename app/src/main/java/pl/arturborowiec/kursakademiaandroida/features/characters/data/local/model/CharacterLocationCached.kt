package pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model

import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationCached(
    val locationName: String,
    val locationUrl: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name,
        characterLocation.url
    )

    fun toCharacterLocation() = CharacterLocation(
        name = locationName,
        url = locationUrl
    )
}
