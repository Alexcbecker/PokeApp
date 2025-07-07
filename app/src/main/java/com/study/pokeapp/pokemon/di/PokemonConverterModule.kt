package com.study.pokeapp.pokemon.di

import com.squareup.moshi.Moshi
import com.study.pokeapp.pokemon.data.PokemonConverters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ConverterModule {

    companion object {
//        @Provides
//        @Singleton
//        fun providePokemonConverters(moshi: Moshi): PokemonConverters = PokemonConverters(moshi)
    }
}
