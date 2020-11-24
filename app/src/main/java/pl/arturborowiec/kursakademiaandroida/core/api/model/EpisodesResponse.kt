package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EpisodesResponse(
    @Json(name = "info") val info: ResponseInfo,
    @Json(name = "results") val results: List<EpisodeRemote>
) {
    companion object
}
