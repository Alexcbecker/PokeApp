package com.study.pokeapp.pokemon.data.bootstrap

import com.squareup.moshi.Moshi
import com.study.pokeapp.pokemon.data.local.AppDatabase
import com.study.pokeapp.pokemon.data.remote.PokemonApiService
import com.study.pokeapp.pokemon.data.toEntity
import javax.inject.Inject

private const val FIRST_GENERATION_LIMIT = 151

class PokemonSeeder @Inject constructor(
    private val api: PokemonApiService,
    private val db: AppDatabase,
    private val moshi: Moshi
) {
    suspend fun seedIfNeeded() {
        val hasData = db.pokemonDao().count() > 0
        if (hasData) return

        val allPokemon = (1..FIRST_GENERATION_LIMIT).mapNotNull { id ->
            try {
                api.getPokemonById(id).toEntity(moshi)
            } catch (e: Exception) {
                //TODO: Add error handler
                null
            }
        }

        db.pokemonDao().insertAll(allPokemon)
    }
}
