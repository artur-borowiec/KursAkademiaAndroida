package pl.arturborowiec.kursakademiaandroida.features.characters.details.presentation

import pl.arturborowiec.kursakademiaandroida.BR
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }
}
