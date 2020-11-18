package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

@Parcelize
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) : Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    val fullName
        get() = "$code $name"

    companion object
}
