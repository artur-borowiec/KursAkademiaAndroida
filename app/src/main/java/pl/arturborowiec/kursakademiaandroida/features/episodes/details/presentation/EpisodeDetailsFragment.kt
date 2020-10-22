package pl.arturborowiec.kursakademiaandroida.features.episodes.details.presentation

import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.EpisodesViewModel


class EpisodeDetailsFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodesViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}
