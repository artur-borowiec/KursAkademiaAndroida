package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterLocation

@JsonClass(generateAdapter = true)
data class CharacterLocationRemote(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
) {
    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}
