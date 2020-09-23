package pl.arturborowiec.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import pl.arturborowiec.kursakademiaandroida.core.base.UIState
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _uiState by lazy { MutableLiveData<UIState>(UIState.Idle) }

    val uiState: LiveData<UIState> by lazy { _uiState }

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }

            result.onFailure {}
        }
    }

    private fun setIdleState() {
        _uiState.value = UIState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UIState.Pending
    }
}
