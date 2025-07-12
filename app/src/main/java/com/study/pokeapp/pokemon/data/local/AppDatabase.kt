package com.study.pokeapp.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.study.pokeapp.pokemon.data.PokemonConverters
import com.study.pokeapp.pokemon.data.local.model.PokemonEntity
import com.study.pokeapp.pokemon.data.local.model.RemoteKeyEntity

@TypeConverters(PokemonConverters::class)
@Database(
    entities = [
        PokemonEntity::class,
        RemoteKeyEntity::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {
        const val DB_NAME = "pokeapp"
    }
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE pokemon ADD COLUMN favorite INTEGER NOT NULL DEFAULT 0")
    }
}
