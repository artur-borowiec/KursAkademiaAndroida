package pl.arturborowiec.kursakademiaandroida.features.episodes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.repository.EpisodesRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.EpisodesRepository
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.EpisodeAdapter
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import pl.arturborowiec.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel

val episodeModule = module {

    // data
    factory<EpisodesRepository> { EpisodesRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }
}
