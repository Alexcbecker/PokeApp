package com.study.pokeapp.pokemon.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon ORDER BY id")
    suspend fun getPokemons(): PagingSource<Int, PokemonEntity>

    @Query("DELETE FROM pokemon")
    suspend fun clearAllPokemons()
}
