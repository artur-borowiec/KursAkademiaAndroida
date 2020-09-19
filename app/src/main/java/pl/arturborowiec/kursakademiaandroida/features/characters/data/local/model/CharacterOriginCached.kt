package pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model

import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

data class CharacterOriginCached(
    val originName: String,
    val originUrl: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = originName,
        url = originUrl
    )
}
