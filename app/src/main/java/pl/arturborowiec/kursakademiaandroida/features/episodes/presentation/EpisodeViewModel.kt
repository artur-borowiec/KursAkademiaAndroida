package pl.arturborowiec.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import com.hadilq.liveevent.LiveEvent
import pl.arturborowiec.kursakademiaandroida.core.base.UIState
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _message by lazy { LiveEvent<String>() }

    val message: LiveData<String> by lazy { _message }

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

            result.onFailure { throwable ->
                throwable.message
                    ?.let { showMessage(it) }
            }
        }
    }

    private fun showMessage(message: String) {
        _message.value = message
    }

    private fun setIdleState() {
        _uiState.value = UIState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UIState.Pending
    }
}
