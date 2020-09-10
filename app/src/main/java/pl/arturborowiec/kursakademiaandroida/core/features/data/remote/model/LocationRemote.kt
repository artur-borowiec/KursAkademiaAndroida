package pl.arturborowiec.kursakademiaandroida.core.features.data.remote.model

import com.google.gson.annotations.SerializedName

data class LocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
