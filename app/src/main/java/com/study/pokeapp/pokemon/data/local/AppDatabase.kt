package com.study.pokeapp.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.study.pokeapp.pokemon.data.PokemonConverters
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity
import com.study.pokeapp.pokemon.data.local.model.RemoteKeyEntity

@TypeConverters(PokemonConverters::class)
@Database(
    entities = [
        PokemonEntity::class,
        RemoteKeyEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {
        const val DB_NAME = "pokeapp"
    }
}
