package pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

@Parcelize
data class LocationDisplayable(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) : Parcelable {
    constructor(location: Location) : this(
        id = location.id,
        dimension = location.dimension,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )

    companion object
}
