package pl.arturborowiec.kursakademiaandroida.features.characters.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.arturborowiec.kursakademiaandroida.features.characters.data.repository.CharactersRepositoryImpl
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.CharactersRepository
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.CharacterAdapter
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.CharacterFragment
import pl.arturborowiec.kursakademiaandroida.features.characters.presentation.CharacterViewModel

val characterModule = module {

    // data
    factory<CharactersRepository> { CharactersRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetCharactersUseCase(get()) }

    // presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
}
