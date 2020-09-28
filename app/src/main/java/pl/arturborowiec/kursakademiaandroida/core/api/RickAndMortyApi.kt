package pl.arturborowiec.kursakademiaandroida.core.api

import pl.arturborowiec.kursakademiaandroida.core.api.model.CharactersResponse
import pl.arturborowiec.kursakademiaandroida.core.api.model.EpisodesResponse
import pl.arturborowiec.kursakademiaandroida.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse
}
