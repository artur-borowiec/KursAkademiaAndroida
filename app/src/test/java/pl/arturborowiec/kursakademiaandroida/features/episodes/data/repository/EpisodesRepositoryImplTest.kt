package pl.arturborowiec.kursakademiaandroida.features.episodes.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import pl.arturborowiec.kursakademiaandroida.core.api.RickAndMortyApi
import pl.arturborowiec.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.arturborowiec.kursakademiaandroida.core.exception.ErrorWrapper
import pl.arturborowiec.kursakademiaandroida.core.network.NetworkStateProvider
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.EpisodesRepository
import pl.arturborowiec.kursakademiaandroida.mock.mock

internal class EpisodesRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN episodes request THEN fetch episodes from API`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: EpisodesRepository =
            EpisodesRepositoryImpl(api, episodeDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { api.getEpisodes() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN episodes request THEN save episodes to local database`() {
        // given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getEpisodes() } returns EpisodesResponse.mock()
        }
        val episodeDao = mockk<EpisodeDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: EpisodesRepository =
            EpisodesRepositoryImpl(api, episodeDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.saveEpisodes(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN episodes request THEN fetch episodes from local database`() {
        // given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val episodeDao = mockk<EpisodeDao> {
            coEvery { getEpisodes() } returns listOf(EpisodeCached.mock(), EpisodeCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: EpisodesRepository =
            EpisodesRepositoryImpl(api, episodeDao, networkStateProvider, errorWrapper)

        // when
        runBlocking { repository.getEpisodes() }

        // then
        coVerify { episodeDao.getEpisodes() }
    }
}
