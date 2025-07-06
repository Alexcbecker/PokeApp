package com.study.pokeapp.pokemon.data.remote

import com.study.pokeapp.pokemon.data.remote.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): PokemonResponse
}
