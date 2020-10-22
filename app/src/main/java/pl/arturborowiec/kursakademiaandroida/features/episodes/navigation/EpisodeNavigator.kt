package pl.arturborowiec.kursakademiaandroida.features.episodes.navigation

import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailScreen(episode: EpisodeDisplayable)
    fun goBack()
}
