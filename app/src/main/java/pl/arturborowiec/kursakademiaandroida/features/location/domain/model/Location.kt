package pl.arturborowiec.kursakademiaandroida.features.location.domain.model

data class Location(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)
