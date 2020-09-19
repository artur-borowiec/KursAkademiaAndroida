package pl.arturborowiec.kursakademiaandroida.core.api

import pl.arturborowiec.kursakademiaandroida.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse
}