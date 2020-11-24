package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

@JsonClass(generateAdapter = true)
data class LocationRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "dimension") val dimension: String,
    @Json(name = "name") val name: String,
    @Json(name = "residents") val residents: List<String>,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String,
    @Json(name = "created") val created: String
) {
    companion object

    fun toLocation() = Location(
        id = id,
        dimension = dimension,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}
