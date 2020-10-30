package pl.arturborowiec.kursakademiaandroida.features.episodes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.repository.EpisodesRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.EpisodesRepository
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.EpisodeAdapter
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.EpisodeFragment
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.EpisodesViewModel
import pl.arturborowiec.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment
import pl.arturborowiec.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsViewModel
import pl.arturborowiec.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import pl.arturborowiec.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl

val episodeModule = module {

    // data
    factory<EpisodesRepository> { EpisodesRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    // navigation
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }

    // presentation
    viewModel { EpisodesViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }
    viewModel { EpisodeDetailsViewModel() }
    factory { EpisodeDetailsFragment() }
    factory { EpisodeAdapter() }
}
