package com.study.pokeapp.pokemon.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getById(id: Int): PokemonEntity

    @Query("SELECT * FROM pokemon ORDER BY id")
    fun getPokemons(): PagingSource<Int, PokemonEntity>

    @Query("SELECT COUNT(*) FROM pokemon")
    suspend fun count(): Int

    @Query("DELETE FROM pokemon")
    suspend fun clearAllPokemons()
}
