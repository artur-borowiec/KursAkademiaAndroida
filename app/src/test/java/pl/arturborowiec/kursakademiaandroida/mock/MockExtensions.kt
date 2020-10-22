package pl.arturborowiec.kursakademiaandroida.mock

import org.jetbrains.annotations.TestOnly
import pl.arturborowiec.kursakademiaandroida.core.api.model.*
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterLocationCached
import pl.arturborowiec.kursakademiaandroida.features.characters.data.local.model.CharacterOriginCached
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.Character
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import pl.arturborowiec.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import pl.arturborowiec.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import pl.arturborowiec.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import pl.arturborowiec.kursakademiaandroida.features.episodes.domain.model.Episode
import pl.arturborowiec.kursakademiaandroida.features.locations.data.local.model.LocationCached
import pl.arturborowiec.kursakademiaandroida.features.locations.domain.model.Location

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    episodes = emptyList(),
    gender = "character gender",
    image = "character image",
    characterLocation = CharacterLocation.mock(),
    name = "character name",
    characterOrigin = CharacterOrigin.mock(),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url"
)

@TestOnly
fun CharacterLocation.Companion.mock() = CharacterLocation(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterOrigin.Companion.mock() = CharacterOrigin(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    episodes = emptyList(),
    gender = "character gender",
    image = "character image",
    location = CharacterLocationRemote.mock(),
    name = "character name",
    origin = CharacterOriginRemote.mock(),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url",
    created = "character created"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterOriginRemote.Companion.mock() = CharacterOriginRemote(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    episodes = emptyList(),
    gender = "character gender",
    image = "character image",
    location = CharacterLocationCached.mock(),
    name = "character name",
    origin = CharacterOriginCached.mock(),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    locationName = "location name",
    locationUrl = "location url"
)

@TestOnly
fun CharacterOriginCached.Companion.mock() = CharacterOriginCached(
    originName = "origin name",
    originUrl = "origin url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
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

@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    dimension = "location dimension",
    name = "location name",
    residents = emptyList(),
    type = "location type",
    url = "location url"
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
