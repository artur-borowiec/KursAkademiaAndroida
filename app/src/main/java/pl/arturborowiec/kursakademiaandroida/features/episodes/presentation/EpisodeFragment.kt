package pl.arturborowiec.kursakademiaandroida.features.episodes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.arturborowiec.kursakademiaandroida.R

class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // TODO: code to display episodes
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }
}
