package pl.arturborowiec.kursakademiaandroida.features.episodes.domain

import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodesRepository {
    suspend fun getEpisodes(): List<Episode>
}
