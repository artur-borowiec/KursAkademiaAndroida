package pl.arturborowiec.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        // init all view-related clases
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        // handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // TODO: code to display episodes
        }
    }
}
