package pl.arturborowiec.kursakademiaandroida.core.features.data.remote.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.core.features.episodes.domain.model.Episode

data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode") val code: String,
    @SerializedName("characters") val characters: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toEpisode(episode: Episode) = Episode(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )
}
