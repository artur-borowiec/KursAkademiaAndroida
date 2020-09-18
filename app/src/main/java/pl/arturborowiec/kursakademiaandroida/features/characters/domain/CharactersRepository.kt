package pl.arturborowiec.kursakademiaandroida.features.characters.domain

import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}
