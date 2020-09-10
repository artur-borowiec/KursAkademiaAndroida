package pl.arturborowiec.kursakademiaandroida.core.features.characters.presentation.model

import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.Character

data class CharacterDisplayable(
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val characterLocation: CharacterLocationDisplayable,
    val name: String,
    val characterOrigin: CharacterOriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        episodes = character.episodes,
        gender = character.gender,
        id = character.id,
        image = character.image,
        characterLocation = CharacterLocationDisplayable(character.characterLocation),
        name = character.name,
        characterOrigin = CharacterOriginDisplayable(character.characterOrigin),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )
}
