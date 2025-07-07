package com.study.pokeapp.pokemon.data.bootstrap

import com.squareup.moshi.Moshi
import com.study.pokeapp.pokemon.data.local.AppDatabase
import com.study.pokeapp.pokemon.data.remote.PokemonApiService
import com.study.pokeapp.pokemon.data.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
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

        val semaphore = Semaphore(permits = 5)

        val pokemons = withContext(Dispatchers.IO) {
            coroutineScope {
                (1..FIRST_GENERATION_LIMIT).map { id ->
                    async {
                        semaphore.withPermit {
                            try {
                                api.getPokemonById(id).toEntity(moshi)
                            } catch (e: Exception) {
                                //TODO: Add error handler
                                null
                            }
                        }
                    }
                }.awaitAll().filterNotNull()
            }
        }

        db.pokemonDao().insertAll(pokemons = pokemons)
    }
}
