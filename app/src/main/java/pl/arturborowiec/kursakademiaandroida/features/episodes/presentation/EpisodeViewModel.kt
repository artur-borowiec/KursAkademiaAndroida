package pl.arturborowiec.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _episodes by lazy {
        MutableLiveData<List<EpisodeDisplayable>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> = _episodes

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<EpisodeDisplayable>>) {
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes.map { EpisodeDisplayable(it) }
            }

            result.onFailure {}
        }
    }
}
