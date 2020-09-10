package pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model

data class Character(
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
