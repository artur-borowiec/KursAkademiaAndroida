package pl.arturborowiec.kursakademiaandroida.core.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model.CharacterLocation

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}
