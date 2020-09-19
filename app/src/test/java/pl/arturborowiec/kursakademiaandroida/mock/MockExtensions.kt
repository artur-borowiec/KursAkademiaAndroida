package pl.arturborowiec.kursakademiaandroida.mock

import org.jetbrains.annotations.TestOnly
import pl.arturborowiec.kursakademiaandroida.core.api.model.*
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.model.LocationCached

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

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    dimension = "location dimension",
    name = "location name",
    residents = emptyList(),
    type = "location type",
    url = "location url",
    created = "location created"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    dimension = "location dimension",
    name = "location name",
    residents = emptyList(),
    type = "location type",
    url = "location url"
)

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)
