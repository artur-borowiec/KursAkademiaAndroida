package pl.arturborowiec.kursakademiaandroida.features.characters.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.core.api.model.CharactersResponse
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.CharacterDao
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.CharactersRepository
import pl.arturborowiec.kursakademiaandroida.mock.mock

internal class CharactersRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharactersRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: CharactersRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val characterDao = mockk<CharacterDao> {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }

        val repository: CharactersRepository =
            CharactersRepositoryImpl(api, characterDao, networkStateProvider)

        // when
        runBlocking { repository.getCharacters() }

        // then
        coVerify { characterDao.getCharacters() }
    }
}
