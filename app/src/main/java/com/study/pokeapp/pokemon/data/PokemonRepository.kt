package com.study.pokeapp.pokemon.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.squareup.moshi.Moshi
import com.study.pokeapp.pokemon.data.local.AppDatabase
import com.study.pokeapp.pokemon.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val PAGE_SIZE = 10

class PokemonRepository @Inject constructor(
    private val database: AppDatabase,
    private val moshi: Moshi
) {
    fun getPokemons(): Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE
        ),
        pagingSourceFactory = { database.pokemonDao().getPokemons() }
    ).flow.map { pagingData ->
        pagingData.map { it.toDomain(moshi) }
    }

    suspend fun toggleFavorite(pokemon: Pokemon) {
        val updatedEntity = pokemon.copy(favorite = !pokemon.favorite).toEntity(moshi)
        database.pokemonDao().update(updatedEntity)
    }
}
