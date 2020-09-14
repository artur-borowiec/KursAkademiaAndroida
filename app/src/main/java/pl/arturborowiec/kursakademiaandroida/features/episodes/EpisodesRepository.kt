package pl.arturborowiec.kursakademiaandroida.features.episodes

import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodesRepository {
    suspend fun getEpisodes(): List<Episode>
}
