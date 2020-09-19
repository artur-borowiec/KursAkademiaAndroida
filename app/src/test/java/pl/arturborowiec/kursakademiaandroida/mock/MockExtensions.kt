package pl.arturborowiec.kursakademiaandroida.mock

import org.jetbrains.annotations.TestOnly
import pl.arturborowiec.kursakademiaandroida.core.api.model.EpisodeRemote
import pl.arturborowiec.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.arturborowiec.kursakademiaandroida.core.api.model.ResponseInfo
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)
