package pl.arturborowiec.kursakademiaandroida.features.locations.domain.model

data class Location(
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    companion object
}
