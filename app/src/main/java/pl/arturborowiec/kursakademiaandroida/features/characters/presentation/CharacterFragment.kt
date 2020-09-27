package pl.arturborowiec.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        // init all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            // TODO: code to display characters
        }
    }
}
