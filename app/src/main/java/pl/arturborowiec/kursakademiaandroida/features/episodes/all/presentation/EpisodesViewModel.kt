package pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import pl.arturborowiec.kursakademiaandroida.core.base.BaseViewModel
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorMapper
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.arturborowiec.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator

class EpisodesViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val episodeNavigator: EpisodeNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

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
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(episode: EpisodeDisplayable) {
        episodeNavigator.openEpisodeDetailScreen(episode)
    }
}
