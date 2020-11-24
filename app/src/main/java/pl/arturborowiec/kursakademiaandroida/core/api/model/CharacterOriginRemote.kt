package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

@JsonClass(generateAdapter = true)
data class CharacterOriginRemote(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
) {
    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}
