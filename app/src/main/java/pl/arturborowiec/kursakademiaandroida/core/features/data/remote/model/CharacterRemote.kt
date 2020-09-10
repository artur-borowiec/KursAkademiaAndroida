package pl.arturborowiec.kursakademiaandroida.core.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.Character

data class CharacterRemote(
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episodes: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharacterLocationRemote,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: CharacterOriginRemote,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() = Character(
        episodes = episodes,
        gender = gender,
        id = id,
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
