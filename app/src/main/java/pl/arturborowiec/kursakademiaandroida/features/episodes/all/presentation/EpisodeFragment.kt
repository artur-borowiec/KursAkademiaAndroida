package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation

import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment
import pl.arturborowiec.kursakademiaandroida.core.extensions.viewBinding
import pl.arturborowiec.kursakademiaandroida.databinding.FragmentEpisodeBinding

class EpisodeFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val adapter: EpisodeAdapter by inject()
    private val binding by viewBinding(FragmentEpisodeBinding::bind)

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
        binding.rvEpisodes.adapter = adapter
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            adapter.setEpisodes(it)
        }
    }
}
