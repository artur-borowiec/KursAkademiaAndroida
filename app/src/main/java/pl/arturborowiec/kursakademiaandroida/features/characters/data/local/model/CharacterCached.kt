package pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episodes: List<String>,
    val gender: String,
    val image: String,
    @Embedded
    val location: CharacterLocationCached,
    val name: String,
    @Embedded
    val origin: CharacterOriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.episodes,
        character.gender,
        character.image,
        CharacterLocationCached(character.characterLocation),
        character.name,
        CharacterOriginCached(character.characterOrigin),
        character.species,
        character.status,
        character.type,
        character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        episodes = episodes,
        gender = gender,
        image = image,
        characterLocation = location.toCharacterLocation(),
        name = name,
        characterOrigin = origin.toCharacterOrigin(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}
