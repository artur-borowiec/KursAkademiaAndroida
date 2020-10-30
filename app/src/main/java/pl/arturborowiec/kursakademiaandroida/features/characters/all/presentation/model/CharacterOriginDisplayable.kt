package pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

@Parcelize
data class CharacterOriginDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )

    companion object
}
