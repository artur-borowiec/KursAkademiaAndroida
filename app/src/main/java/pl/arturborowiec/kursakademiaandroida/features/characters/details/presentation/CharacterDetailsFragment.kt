package pl.arturborowiec.kursakademiaandroida.features.characters.details.presentation

import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }
}
