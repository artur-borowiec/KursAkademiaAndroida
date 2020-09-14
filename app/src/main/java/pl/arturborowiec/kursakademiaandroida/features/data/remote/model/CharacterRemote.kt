package pl.arturborowiec.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("created") val created: String,
    @SerializedName("episode") val episodes: List<String>,
    @SerializedName("gender") val gender: String,
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
