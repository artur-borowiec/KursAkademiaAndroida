package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

@JsonClass(generateAdapter = true)
data class EpisodeRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "air_date") val airDate: String,
    @Json(name = "episode") val code: String,
    @Json(name = "characters") val characters: List<String>,
    @Json(name = "url") val url: String,
    @Json(name = "created") val created: String
) {
    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}
