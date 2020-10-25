package pl.arturborowiec.kursakademiaandroida.features.characters.navigation

import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.navigation.FragmentNavigator
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import pl.arturborowiec.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : CharacterNavigator {

    override fun openCharacterDetailScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_characters_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}
