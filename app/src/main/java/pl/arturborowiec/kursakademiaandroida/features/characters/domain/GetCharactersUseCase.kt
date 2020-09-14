package pl.arturborowiec.kursakademiaandroida.features.characters.domain

import pl.arturborowiec.kursakademiaandroida.base.UseCase
import pl.arturborowiec.kursakademiaandroida.features.characters.CharactersRepository
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = charactersRepository.getCharacters()
}
