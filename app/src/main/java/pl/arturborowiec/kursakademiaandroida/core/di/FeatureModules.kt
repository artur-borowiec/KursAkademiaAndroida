package pl.arturborowiec.kursakademiaandroida.core.di

import pl.arturborowiec.kursakademiaandroida.features.characters.di.characterModule
import pl.arturborowiec.kursakademiaandroida.features.episodes.di.episodeModule
import pl.arturborowiec.kursakademiaandroida.features.locations.di.locationModule

val featureModules = listOf(
    characterModule,
    episodeModule,
    locationModule
)
