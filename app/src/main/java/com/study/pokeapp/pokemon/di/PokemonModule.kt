package com.study.pokeapp.pokemon.di

import android.content.Context
import androidx.room.Room
import com.study.pokeapp.pokemon.data.local.AppDatabase
import com.study.pokeapp.pokemon.data.PokemonConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PokemonModule {
    companion object {
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext applicationContext: Context,
            pokemonConverters: PokemonConverters
        ) = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        )
            .addTypeConverter(pokemonConverters)
            .build()
    }
}
