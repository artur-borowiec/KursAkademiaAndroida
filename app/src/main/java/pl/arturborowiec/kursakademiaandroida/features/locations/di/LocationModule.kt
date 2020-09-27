package pl.arturborowiec.kursakademiaandroida.features.locations.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.locations.data.repository.LocationsRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.LocationsRepository
import pl.arturborowiec.kursakademiaandroida.features.locations.presentation.LocationFragment
import pl.arturborowiec.kursakademiaandroida.features.locations.presentation.LocationViewModel

val locationModule = module {

    // data
    factory<LocationsRepository> { LocationsRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetLocationsUseCase(get()) }

    // presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
}
