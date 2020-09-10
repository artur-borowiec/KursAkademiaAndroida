package pl.arturborowiec.kursakademiaandroida.core.features.characters.domain.model

data class Character(
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val characterLocation: CharacterLocation,
    val name: String,
    val characterOrigin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
