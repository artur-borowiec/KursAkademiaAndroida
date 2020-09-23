package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}
