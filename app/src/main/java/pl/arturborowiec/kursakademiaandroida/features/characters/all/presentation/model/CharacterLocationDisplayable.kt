package pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterLocation

@Parcelize
data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object
}
