package pl.arturborowiec.kursakademiaandroida.features.locations.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.LocationAdapter
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.LocationFragment
import pl.arturborowiec.kursakademiaandroida.features.locations.all.presentation.LocationViewModel
import pl.arturborowiec.kursakademiaandroida.features.locations.data.repository.LocationsRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment
import pl.arturborowiec.kursakademiaandroida.features.locations.details.presentation.LocationDetailsViewModel
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.LocationsRepository
import pl.arturborowiec.kursakademiaandroida.features.locations.navigation.LocationNavigator
import pl.arturborowiec.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl

val locationModule = module {

    // data
    factory<LocationsRepository> { LocationsRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetLocationsUseCase(get()) }

    // navigation
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }

    // presentation
    viewModel { LocationViewModel(get(), get(), get()) }
    factory { LocationFragment() }
    viewModel { LocationDetailsViewModel() }
    factory { LocationDetailsFragment() }
    factory { LocationAdapter() }
}
