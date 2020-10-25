package pl.arturborowiec.kursakademiaandroida.features.characters.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.CharacterAdapter
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.CharacterFragment
import pl.arturborowiec.kursakademiaandroida.features.characters.all.presentation.CharacterViewModel
import pl.arturborowiec.kursakademiaandroida.features.characters.data.repository.CharactersRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import pl.arturborowiec.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsViewModel
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.CharactersRepository
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import pl.arturborowiec.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import pl.arturborowiec.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl

val characterModule = module {

    // data
    factory<CharactersRepository> { CharactersRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetCharactersUseCase(get()) }

    // navigation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }

    // presentation
    viewModel { CharacterViewModel(get(), get(), get()) }
    factory { CharacterFragment() }
    viewModel { CharacterDetailsViewModel() }
    factory { CharacterDetailsFragment() }
    factory { CharacterAdapter() }
}
