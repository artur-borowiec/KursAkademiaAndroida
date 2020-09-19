package pl.arturborowiec.kursakademiaandroida.features.episodes.data.repository

import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.EpisodesRepository
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodesRepositoryImpl(
    private val api: RickAndMortyApi
): EpisodesRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes()
            .results
            .map { it.toEpisode() }
    }
}
