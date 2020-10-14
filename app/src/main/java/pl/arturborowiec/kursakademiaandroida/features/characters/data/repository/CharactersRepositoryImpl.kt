package pl.arturborowiec.kursakademiaandroida.features.characters.data.repository

import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapper
import pl.arturborowiec.kursakademiaandroida.core.exception.callOrThrow
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.CharactersRepository
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character

class CharactersRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getCharactersFromRemote() }
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }
    }
}
