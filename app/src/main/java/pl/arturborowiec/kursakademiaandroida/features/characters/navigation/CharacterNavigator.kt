package pl.arturborowiec.kursakademiaandroida.features.characters.navigation

import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailScreen(character: CharacterDisplayable)
    fun goBack()
}
