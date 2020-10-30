package pl.arturborowiec.kursakademiaandroida.features.episodes.details.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment


class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}
