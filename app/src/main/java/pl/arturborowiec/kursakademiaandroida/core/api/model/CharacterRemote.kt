package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

@JsonClass(generateAdapter = true)
data class CharacterRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "episode") val episodes: List<String>,
    @Json(name = "gender") val gender: String,
    @Json(name = "image") val image: String,
    @Json(name = "location") val location: CharacterLocationRemote,
    @Json(name = "name") val name: String,
    @Json(name = "origin") val origin: CharacterOriginRemote,
    @Json(name = "species") val species: String,
    @Json(name = "status") val status: String,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String,
    @Json(name = "created") val created: String
) {
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
