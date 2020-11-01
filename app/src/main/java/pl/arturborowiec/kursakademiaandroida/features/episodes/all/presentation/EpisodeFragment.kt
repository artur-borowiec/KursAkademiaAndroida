package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation

import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.BR
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentEpisodeBinding

class EpisodeFragment : BaseFragment<EpisodesViewModel, FragmentEpisodeBinding>(
    BR.viewModel,
    R.layout.fragment_episode
) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val adapter: EpisodeAdapter by inject()

    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
        binding?.let {
            rvEpisodes.adapter = adapter
        }
    }
}
