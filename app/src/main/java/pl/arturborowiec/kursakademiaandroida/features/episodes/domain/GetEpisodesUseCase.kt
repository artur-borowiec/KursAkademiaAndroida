package pl.arturborowiec.kursakademiaandroida.features.episodes.domain

import pl.arturborowiec.kursakademiaandroida.core.base.UseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodesRepository: EpisodesRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodesRepository.getEpisodes()
}
