package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R
import pl.arturborowiec.kursakademiaandroida.core.base.BaseFragment

class EpisodeFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()

    private val gridLayoutManager: GridLayoutManager by inject()
    private val adapter: EpisodeAdapter by inject()

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
        rvEpisodes.layoutManager = gridLayoutManager
        rvEpisodes.adapter = adapter
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

    override fun onDestroyView() {
        with(rvEpisodes) {
            layoutManager = null
            adapter = null
        }
        super.onDestroyView()
    }
}
