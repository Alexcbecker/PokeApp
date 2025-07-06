package com.study.pokeapp.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity
import com.study.pokeapp.pokemon.data.local.model.RemoteKeyEntity

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
