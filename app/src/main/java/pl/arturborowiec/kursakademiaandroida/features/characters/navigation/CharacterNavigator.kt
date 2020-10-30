package pl.arturborowiec.kursakademiaandroida.features.characters.navigation

import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}
