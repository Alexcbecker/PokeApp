package com.study.pokeapp.pokemon.di

import com.squareup.moshi.Moshi
import com.study.pokeapp.pokemon.data.PokemonConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ConverterModule {

    @Provides
    fun providePokemonConverters(moshi: Moshi): PokemonConverters {
        return PokemonConverters(moshi)
    }
}
