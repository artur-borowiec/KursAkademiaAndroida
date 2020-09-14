package pl.arturborowiec.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}
