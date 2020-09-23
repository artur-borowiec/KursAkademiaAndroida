package pl.arturborowiec.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

data class LocationRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("name") val name: String,
    @SerializedName("residents") val residents: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
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
