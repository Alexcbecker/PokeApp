package com.study.pokeapp.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class,
        //TODO: Create RemoteKeyEntity for paging lib
//        RemoteKeyEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    //TODO: Create dao classes
//    abstract fun pokemonDao(): PokemonDao
//    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {
        const val DB_NAME = "pokeapp"
    }
}
